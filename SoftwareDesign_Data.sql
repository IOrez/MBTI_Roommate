INSERT INTO `SoftwareDesign`.`University`
(`univ`,
`uname`)
VALUES
(1111,
"경북대학교(대구캠)");
INSERT INTO `SoftwareDesign`.`University`
(`univ`,
`uname`)
VALUES
(1112,
"경북대학교(상주캠)");

INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110001,
"첨성관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110002,
"성실관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110003,
"긍지관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110004,
"협동관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110005,
"봉사관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110006,
"진리관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110007,
"화목관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110008,
"면학관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110009,
"향토관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110010,
"명의관");
INSERT INTO `SoftwareDesign`.`Dormitory`
(`pdormitory`,
`dname`)
VALUES
(11110011,
"누리관");


INSERT INTO `SoftwareDesign`.`Major`
(`pmajor`,
`mname`)
VALUES
(11110001,
"컴퓨터학부");
INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("guest",
"password",
"이종훈",
0,
1,
1111,
11110001,
"ljh5363@knu.ac.kr",
11110001,
0,
"-",
23,
"오픈카톡방",
11,
8,
0,
0);

INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("guest2",
"password",
"이종제",
0,
12,
1111,
11110001,
"kkk1111@knu.ac.kr",
11110001,
0,
"-",
25,
"전화번호",
12,
6,
0,
0);

INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("guest3",
"password",
"김수현",
1,
5,
1111,
11110001,
"ijk2020@knu.ac.kr",
"11110001",
0,
"-",
27,
"삐삐번호",
10,
7,
0,
0);

INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("guest4",
"password",
"오수진",
1,
9,
1111,
11110001,
"ikt3214@knu.ac.kr",
"11110001",
0,
"-",
27,
"오픈카톡방",
10,
7,
0,
0);

INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("guest5",
"password",
"박권유",
1,
11,
1111,
11110001,
"kikiki@knu.ac.kr",
"11110001",
0,
"-",
26,
"오픈카톡방",
12,
8,
0,
0);

INSERT INTO `SoftwareDesign`.`User`
(`id`,
`password`,
`pname`,
`pgender`,
`pmbti`,
`univ`,
`pmajor`,
`email`,
`pdormitory`,
`psmoke`,
`pcomment`,
`page`,
`pcontact`,
`pstime`,
`pshour`,
`hasMatchBefore`,
`isMatched`)
VALUES
("oute1001",
"dltjgus07_",
"이서현",
0,
3,
1111,
11110001,
"oute1001@knu.ac.kr",
"11110001",
0,
"appeal yourself to your roommates!",
22,
"oute1001@knu.ac.kr",
12,
8,
0,
0);


