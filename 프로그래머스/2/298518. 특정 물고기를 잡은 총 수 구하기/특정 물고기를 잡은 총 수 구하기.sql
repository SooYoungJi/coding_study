SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO FI RIGHT JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FNI.FISH_NAME IN ('BASS', 'SNAPPER')













# -- 코드를 작성해주세요
# SELECT COUNT(*) AS FISH_COUNT
# FROM FISH_INFO
# WHERE FISH_TYPE IN (SELECT A.FISH_TYPE 
#                     FROM FISH_INFO A JOIN FISH_NAME_INFO B 
#                     ON A.FISH_TYPE = B.FISH_TYPE 
#                     WHERE B.FISH_NAME IN ('BASS', 'SNAPPER'))