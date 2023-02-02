# PNUProject_1


■ 데이터 
- pycaret-pt1.ipynb   
feature = machinery, assembly, 청구품목, part1을 바탕으로 pycaret 돌려본 버전   
![image](https://user-images.githubusercontent.com/113881813/216200335-005c154b-4365-4ae4-910d-d84fd765184a.png)   

가장 정확도가 잘 나오는 모델은 ridge classifier라고 한다



카테고리를 맞추기 위한 feature로 subject, 'machinery'  , 'assembly' , 'items'를 골랐다.   
왜냐하면 여기에는 key2에 해당하는 단어의 일부가 포함되어 있기 때문에 당연히 의미가 있을 것이라고 직관적으로 고른 거임.   
주성분분석을 해서 뭐가 의미가 있는지 알아보라고 하셨는데 일단은 보류를 하고 시간이 된다면...   

그래서 setup을 해서 accuracy를 좀 뽑고 더 할 수 있으면 setup의 파라미터를 건드려보거나 feature를 늘려보거나 할 수 있을 수도 있음   
