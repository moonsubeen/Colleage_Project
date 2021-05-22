# HOW to use
----------------
### Login
- 로그인 명령어로 아이디와 비밀번호를 입력하세요
	```
	> login admin 0000
	```
### Register
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
	> read
	> read -a
	> read -le
	> read -les -c 543013
### Lecture
	> lecture -e -c 543013 -ev 좋음
	> lecture -ga -c 543013 -g 90
	> lecture -p -c 543013 -pr 없음
### Logout
	> logout
