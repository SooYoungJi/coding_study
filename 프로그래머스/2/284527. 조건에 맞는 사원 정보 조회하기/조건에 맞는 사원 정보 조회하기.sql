SELECT SUM(SCORE) AS SCORE, EM.EMP_NO, EM.EMP_NAME, EM.POSITION, EM.EMAIL
FROM HR_GRADE G LEFT JOIN HR_EMPLOYEES EM ON G.EMP_NO = EM.EMP_NO
GROUP BY G.EMP_NO
ORDER BY 1 DESC
LIMIT 1













# -- 코드를 작성해주세요
# SELECT A.SCORE, B.EMP_NO, B.EMP_NAME, B.POSITION, B.EMAIL
# FROM (SELECT EMP_NO, SUM(SCORE) AS SCORE FROM HR_GRADE GROUP BY EMP_NO) A JOIN HR_EMPLOYEES B
# ON A.EMP_NO = B.EMP_NO
# ORDER BY SCORE DESC
# LIMIT 1