from importlib import machinery

from keras.layers import Input, Dense
from keras.models import Model
from keras.optimizers import RMSprop
from keras import backend as K
import tensorflow as tf

from sklearn import preprocessing
label_encoder = preprocessing.LabelEncoder()
import io
import pandas as pd
import pymysql
import joblib

from sklearn.preprocessing import LabelEncoder

class MultiColumnLabelEncoder:

    def __init__(self, columns=None):
        self.columns = columns # array of column names to encode

    def fit(self, X, y=None):
        self.encoders = {}
        columns = X.columns if self.columns is None else self.columns
        for col in columns:
            self.encoders[col] = LabelEncoder().fit(X[col])
        return self

    def transform(self, X):
        output = X.copy()
        columns = X.columns if self.columns is None else self.columns
        for col in columns:
            output[col] = self.encoders[col].transform(X[col])
        return output


    def fit_transform(self, X, y=None):
        return self.fit(X,y).transform(X)


    def inverse_transform(self, X):
        output = X.copy()
        columns = X.columns if self.columns is None else self.columns
        for col in columns:
            output[col] = self.encoders[col].inverse_transform(X[col])
        return output


def ModelLeadtime():
    conn=pymysql.connect(host='*.com',port=3306,user='*',password='*',db='*', cursorclass=pymysql.cursors.DictCursor)
    cursor = conn.cursor()
    sql = "select * from leadtime_test_insert"
    cursor.execute(sql)
    result = cursor.fetchall()
    conn.close()
    original = pd.DataFrame(result)

    features_4 = ['assembly', 'gyeonjeok', 'gyeonjeokhwapye', 'dt']
    multi = MultiColumnLabelEncoder(columns=['assembly', 'gyeonjeok', 'gyeonjeokhwapye'])
    original1 = multi.fit_transform(original)



    model4 = joblib.load('./Model_Leadtime.pkl')
    db = original1.loc[:, features_4]

    prediction = model4.predict(db)
    pred_df = pd.DataFrame(prediction)
    pred_df = pred_df.astype(int)
    pred_df.columns = ['leadtime_predicted']
    concat = pd.concat([db, pred_df], axis=1)
    concat = multi.inverse_transform(concat)

    db = original1.loc[:, features_4]
    prediction = model4.predict(db)
    pred_df = pd.DataFrame(prediction)
    pred_df = pred_df.astype(int)
    pred_df.columns = ['leadtime_predicted']
    concat = pd.concat([db, pred_df], axis=1)
    concat = multi.inverse_transform(concat)
    essential = ['machinery', 'items', 'part1', 'key2', 'balju', 'baljucheo', 'changgoipgo', 'leadtime']
    final = pd.concat([original[essential], concat], axis=1)
    final['차이'] = (final['leadtime_predicted'] - final['leadtime']).abs()
    final.drop(final[(final['차이'] >= 4)].index, inplace=True)

    from sqlalchemy import create_engine
    db_connection_str = '*.com/*'
    db_connection = create_engine(db_connection_str)
    conn = db_connection.connect()
    print("start")
    final.to_sql(name='leadtime_final_pyRe', con=db_connection, if_exists='replace',index=False)
    print("end")