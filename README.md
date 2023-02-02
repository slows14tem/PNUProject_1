# PNUProject_1


■ 데이터 
- pycaret-pt1.ipynb   
feature = machinery, assembly, 청구품목, part1을 바탕으로 pycaret 돌려본 버전   
![image](https://user-images.githubusercontent.com/113881813/216200335-005c154b-4365-4ae4-910d-d84fd765184a.png)   

가장 정확도가 잘 나오는 모델은 ridge classifier라고 한다

- 분류7트_테스트용.ipynb
위에서 저장한 모델을 db에 넣기 위해 만든 파일   
![image](https://user-images.githubusercontent.com/113881813/216206812-50609367-5274-4850-8e9f-02052a123765.png)   
불러와서   
![image](https://user-images.githubusercontent.com/113881813/216206850-d3413725-3397-4c4b-a2f7-2de3a5599838.png)   
로드하고   
![image](https://user-images.githubusercontent.com/113881813/216206904-e54ec8d5-e278-4a7b-b4c2-25d3fa808497.png)   
넣는다.   

- classification_0721 - 복사본2.ipynb   
"니가 쓸 feature를 설명도 못하는 게 말이 되냐"고 하셔서 열을 다시 고르고 돌려본 파일   

카테고리를 맞추기 위한 feature로 subject, 'machinery'  , 'assembly' , 'items'를 골랐다.   
왜냐하면 여기에는 key2에 해당하는 단어의 일부가 포함되어 있기 때문에 당연히 의미가 있을 것이라고 직관적으로 고른 거임.   
주성분분석을 해서 뭐가 의미가 있는지 알아보라고 하셨는데 지금 할 겨를이 없음   

그래서 part1을 빼고 subject를 넣어서 pycaret을 돌려봤는데 상황이 안 좋다   
![image](https://user-images.githubusercontent.com/113881813/216207648-f590bb5b-9985-41a7-8ded-85ef641f0b78.png)   

그래서 sklearn.ensemble에 있는 RandomForestClassifier를 써 보기로 했다   
![image](https://user-images.githubusercontent.com/113881813/216207884-d8d3d505-e91c-43b2-b072-18876d807c27.png)   
pycaret보다 상황이 좋아졌다.   

2월 2일 지적사항   
"니가 만든 코드를 함수로 해서 자동화해야 여러 개 돌릴 수 있다"   
- 전처리
"문자를 다짜고짜 LabelEncoder()로 돌리지 말고, text embedding이라는 걸 해라"   
"feature가 여러 개가 있는데 이를 어떻게 조합할지 만들어 주는 거를 찾아봐라. 파이썬 combination 이렇게 검색해보면 될 것같다"   
"숫자는 MinMaxScaler를 해서 그것도 인코딩을 하고"   
"저장을 하고."   

"이런 것들을 함수로 만들어야 니가 짧은 시간에 많이 돌릴 수 있다"   

![image](https://user-images.githubusercontent.com/113881813/216211144-04d629f2-10e5-42b3-a929-ce9f32077bc4.png)   
- feature 해석   
Machinery는 명칭이다   
Assembly - Machinery 안에 들어가는 부품   
청구품목 - Assembly를 더 구체화한 거.   
