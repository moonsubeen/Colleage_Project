# HOW to use
----------------
### Login
- 로그인 명령어로 아이디와 비밀번호를 입력하세요
	```
	> login admin 0000
	```
### Register
- 등록 명령어로 각종 서브 명령과 옵션이 필요하 필수 옵션으로 id가 있다

|서브 명령어|의미|권한|
|:---:|:---:|:---:|
|'user'|유저 아이디 생성|admin|
|'professor'|교수정보 입력|admin|
|'student'|학생정보 입력|admin|
|'soldierinfo'|군정보 입력|admin|
|'family'|유저 가족정보 입력|admin|
|'disability'|장애 유무정보 입력|admin|
|'lecture'|강의 개설|professor|
|'lecture2'|강의 점수 입력|professor|
|'lecture3'|강의 출석 입력|professor|

|옵션|의미|기본어|
|:---:|:---:|:---:|
|-i|아이디|id|
|-n|이름|name|
|-e|이메일|email|
|-na|국가|nationality|
|-p|휴대폰 번호|phoneNumber|
|-a|주소|address|
|-re|주민번호|residentNumber|
|-b|생년월일|birthdate|
|-s|성별|sex|
|-r|역할군|role|
|-f|학부|faculty|
|-d|학과|department|
|-m|전공|major|
|-ca|캠퍼스|campus|
|-st|유무|state|
|-mn|군번|militaryNumber|
|-t|군별|type|
|-cl|역종|classification|
|-br|병과|branch|
|-ra|계급|rank|
|-jd|입대일자|joinDate|
|-dd|전역일자|dischageDate|
|-rl|가족관계|relation|
|-di|병명|disability|
|-di|증빙서류|document|
|-c|강의코드|code|
|-y|년도|year|
|-se|학기|semester|
|-da|요일|day|
|-ti|시간|time|
|-co|인원수|count|
|-po|학점|point|
|-pl|강의계획서|plan|
|-g|점수|grade|
|-mo|월|month|
|-at|출석 상태|attendance|
	```
	> register user -n 홍길동 -i 2018 -e zx04090@naver.com -na 한국 -p 010-5568-5870 -a 안산 -re 990426-1****** -b 990426 -s 남 -r student
	> register professor -i 2019 -f 수학부 -d 수학공학과
	> register student -i 2018 -m computer -ca 본캠
	> register soldierinfo -i 2018 -st -mn 513426 -t 육군 -cl 복무요원 -br 없음 -ra 일병 -jd 21년1월14일 -dd 22년10월13일
	> register family -i 2018 -n 길순 -rl 엄마 -p 010-xxxx-xxxx
	> register disabilityinfo -i 2018 -st -di 없음 -do 없음
	> register lecture -i 2019 -c 543013 -n 공학수학 -y 21 -se 1 -da 월요일 -ti 3시간 -co 18 -po 3 -pl 공학수학을합니다.
	> register lecture2 -c 543013 -i 2018 -g 80
	> register lecture3 -i 2018 -c 543013 -mo 3 -da 5 -at 출석
	```
### Read
- 읽기 명령어로 옵션이 서브 명령어로 인식되어있으며 특정강의의 출석확인과 특정강의 정보를 읽을때만 옵션인 code를 이용한다
|서브 명령 옵션|의미|admin|student|professor|
|-a, -all|모든 유저정보 읽기|O|-|-|
|-s|학생정보 읽기|-|O|-|
|-p|교수정보 일기|-|-|O|
|-l|강의정보 읽기|O|O|O|
|-la|모든강의정보 읽기|professor|
|-lh|강의점수 읽기|student|
|-lha|강의기록정보 읽기|professor|
|-le|강의출석정보 읽기|student|
|-les|특정강의출석정보 읽기|student|
|-lea|모든강의출석정보 읽기|professor|
	```
	> read
	> read -a
	> read -s
	> read -p
	> read -l -c 543013
	> read -la
	> read -lh
	> read -lha
	> read -le
	> read -les -c 543013
	> read -lea
	```
### Lecture
- 강의에 대한 문제제기 신청, 강의 평가, 점수 입력을 위한 명령어로 서브 명령 옵션과 일반 옵션으로 구성한다.
|서브 명령 옵션|의미|권한|
|:---:|:---:|:---:|
|-e|강의평가|student|
|-p|문제제기|studennt|
|-ga|점수입력|professor|

|옵션|의미|기본어|
|:---:|:---:|:---:|
|-ga|점수|attendance|
|-ev|
	> lecture -e -c 543013 -ev 좋음
	> lecture -ga -c 543013 -g 90
	> lecture -p -c 543013 -pr 없음
### Logout
	> logout
