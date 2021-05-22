# HOW to use
----------------
### Login
- 로그인 명령어로 아이디와 비밀번호를 입력하세요
	```
	> login admin 0000
	```
### Register
	> register user -n 홍길동 -i 2018 -e zx04090@naver.com -na 한국 -p 010-5568-5870 -a 안산 -re 990426-1****** -b 990426 -s 남 -r student
	> register professor -i 2019 -f 수학부 -d 수학공학과
	> register student -i 2018 -m computer -ca 본캠
	> register soldierinfo -i 2018 -st -mn 513426 -t 육군 -cl 복무요원 -br 없음 -ra 일병 -jd 21년1월14일 -dd 22년10월13일
	> register family -i 2018 -n 길순 -rl 엄마 -p 010-xxxx-xxxx
	> register disabilityinfo -i 2018 -st -di 없음 -do 없음
	> register lecture -i 2019 -c 543013 -n 공학수학 -y 21 -se 1 -da 월요일 -ti 3시간 -co 18 -po 3 -pl 공학수학을합니다.
	> register lecture2 -c 543013 -i 2018 -g 80
	> register lecture3 -i 2018 -c 543013 -mo 3 -da 5 -at 출석
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
