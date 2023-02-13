from category import ModelCategory
from leadtime import ModelLeadtime
import uvicorn
from fastapi import FastAPI

app = FastAPI()


@app.get("/")
def printHello():
    return "모델 예측 서비스입니다. " \
           "db에 예측하고자 하는 값을 인입하셨는지 확인하시고 /docs에서 try it out을 클릭하십시오."


@app.post("/bigdata")
def predict_species():
    ModelCategory()
    ModelLeadtime()
    return '실행됨'


if __name__ == '__main__':
    uvicorn.run(app, host='127.0.0.1', port=8000)
