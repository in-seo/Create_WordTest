<h1>학생 단어출제 프로그램</h1>
<h2>Subtitle : Word Spring</h2>

>1. 학생 등록, 리스트 나열 : 학생을 등록하여, 명단 및 출제된 단어 시험을 볼 수 있다.

>2. 단어 생성, 출제 : 단어장에 단어들을 등록하고, 원하는 범위의 단어를 단어장에서 가져온다.

>3. 단어 배포 : 원하는 단어의 조합으로 시험을 만들고 그 시험을 학생에게 배포한다. 

# **Home.html**
![ddd](https://user-images.githubusercontent.com/94730032/154782191-c91b9d84-b6c3-42d9-8e7d-168961e7d4e5.png)

# <small>간단한 E-R 다이어그램 틀</small>

![1](https://user-images.githubusercontent.com/94730032/154607471-e26405a8-87a7-4792-a485-433e836d3280.png)
<br><br><hr>
# <small>학생 등록(/students/new)</small>
![first](https://user-images.githubusercontent.com/94730032/154610822-0ff859e6-5cc3-43c4-8149-f7f54a554d0c.jpg)
# <small>학생 리스트(/students/list)</small>
![student_list](https://user-images.githubusercontent.com/94730032/154610906-6331bbae-06e8-4f2c-82f4-65911c2e38d1.png)
# <small>단어 생성 및 등록(/words/new)</small>
>단어장 엔티티의 Map<Word> 구조를 이용해서 1번 키부터 차례로 단어장에 등록하게 한다.

![second](https://user-images.githubusercontent.com/94730032/154611071-8c85b684-f939-4824-a6b4-9d4216af94cf.jpg)
# <small>등록된 단어 출제(/distribute) --> 시험 생성</small>
![third](https://user-images.githubusercontent.com/94730032/154611812-c565ced6-18d4-47eb-941c-70341e59f395.jpg)
# <small>생성된 시험 배포-->반별로 각 학생에게(/distributeList)</small>
![forth](https://user-images.githubusercontent.com/94730032/154611841-970c0ac4-deca-429c-858d-cd5953e142fa.jpg)
># 배포된 시험수 업데이트 및,  본인의 시험으로 이동하는 링크 제작예정
![image](https://user-images.githubusercontent.com/94730032/154615463-52fbd792-7fe0-4e94-8d37-fe947ce1b146.png)
<hr>
>2/28까지 mvc학습으로  학생을 파라미터로 넘겨서 
>그 학생의 전용 페이지가 열리게 하는 방법 학습 예정.
