SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I RIGHT JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.DATETIME IS NOT NULL AND I.DATETIME IS NULL
ORDER BY 1












# -- 코드를 입력하세요
# SELECT b.ANIMAL_ID, b.NAME
# FROM ANIMAL_INS a RIGHT JOIN ANIMAL_OUTS b
# ON a.ANIMAL_ID = b.ANIMAL_ID
# WHERE a.ANIMAL_ID IS NULL