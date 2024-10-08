SELECT A.ID, CASE 
            WHEN A.S_RANK * 100 / A.TOTAL_COUNT <= 25 THEN "CRITICAL"
            WHEN A.S_RANK * 100 / A.TOTAL_COUNT <= 50 THEN "HIGH"
            WHEN A.S_RANK * 100 / A.TOTAL_COUNT <= 75 THEN "MEDIUM"
            ELSE "LOW" END AS COLONY_NAME
FROM (SELECT *, RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS S_RANK, 
                COUNT(*) OVER () AS TOTAL_COUNT FROM ECOLI_DATA) AS A
ORDER BY 1















# SELECT ID, 
#     CASE
#         WHEN A.S_RANK/A.TOTAL_COUNT <= 0.25 THEN "CRITICAL"
#         WHEN A.S_RANK/A.TOTAL_COUNT <= 0.5 THEN "HIGH"
#         WHEN A.S_RANK/A.TOTAL_COUNT <= 0.75 THEN "MEDIUM"
#         ELSE "LOW"
#         END AS COLONY_NAME
# FROM (SELECT *, RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS S_RANK,
#      COUNT(*) OVER () AS TOTAL_COUNT FROM ECOLI_DATA) AS A
# ORDER BY ID