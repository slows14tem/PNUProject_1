import joblib
from sklearn import preprocessing
label_encoder = preprocessing.LabelEncoder()
import io
import pandas as pd

from sklearn.preprocessing import LabelEncoder
from sklearn.preprocessing import LabelEncoder
# from pycaret.classification import *
import pymysql
from sqlalchemy import create_engine


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



def ModelCategory():
    conn=pymysql.connect(host='*.com',port=3306,user='*',password='*',db='*', cursorclass=pymysql.cursors.DictCursor)
    cursor = conn.cursor()
    sql = "select * from category_test_insert3"
    cursor.execute(sql)
    result = cursor.fetchall()
    conn.close()
    original = pd.DataFrame(result)

    multi = MultiColumnLabelEncoder(columns=['machinery'  , 'assembly' , 'items', 'part1'])
    original1 = multi.fit_transform(original)

    model_rf = joblib.load('./Model_Category.pkl')
    db = original1.loc[:, ['machinery', 'assembly', 'items', 'part1']]
    prediction = model_rf.predict(db)
    pred_df = pd.DataFrame(prediction)

    concat = pd.concat([db, pred_df], axis=1)
    concat.columns = ['machinery', 'assembly', 'items', 'part1', 'key2']
    prediction_inv = multi.inverse_transform(concat)
    prediction_inv.columns =['machinery', 'assembly', 'items', 'part1', 'predicted']
    prediction_inv2 = pd.concat([prediction_inv, original['key2']], axis=1)



    db_connection_str = '*.com/*'
    db_connection = create_engine(db_connection_str)
    conn = db_connection.connect()
    print("123")
    prediction_inv2.to_sql(name='category_result_pyRe', con=db_connection, if_exists='replace',index=True)
    print("456")
