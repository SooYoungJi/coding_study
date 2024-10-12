SELECT CRCRH.CAR_ID, CRCC.CAR_TYPE, ROUND((CRCC.DAILY_FEE*(100-CRCDP.DISCOUNT_RATE)*0.01*30)) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH LEFT JOIN CAR_RENTAL_COMPANY_CAR CRCC ON CRCRH.CAR_ID = CRCC.CAR_ID LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CRCDP ON CRCC.CAR_TYPE = CRCDP.CAR_TYPE
WHERE CRCC.CAR_TYPE IN ("세단", "SUV")
    AND CRCRH.CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                            WHERE START_DATE <= "2022-11-01" AND END_DATE >= "2022-11-01")
    AND CRCDP.DURATION_TYPE = "30일 이상"
GROUP BY CRCRH.CAR_ID
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, 2, 1 DESC













# -- 코드를 입력하세요
# SELECT DISTINCT CRCC.CAR_ID, CRCC.CAR_TYPE, FLOOR(CRCC.DAILY_FEE*(1 - (SUBSTRING_INDEX(CRCDP.DISCOUNT_RATE, '%', 1))*0.01)*30) AS FEE
# FROM CAR_RENTAL_COMPANY_CAR CRCC 
#     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH ON CRCC.CAR_ID = CRCRH.CAR_ID
#     JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN CRCDP ON CRCC.CAR_TYPE = CRCDP.CAR_TYPE
# WHERE CRCC.CAR_TYPE IN ('세단', 'SUV') 
#     AND CRCC.CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-01')
#     AND CRCDP.DURATION_TYPE = '30일 이상'
# HAVING FEE BETWEEN 500000 AND 2000000-1
# ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;

# /* 최종 테이블의 컬럼 선택 (CAR_ID, CAR_TYPE, FEE) */
# select A.CAR_ID, A.CAR_TYPE, ROUND(DAILY_FEE*30*((100-DISCOUNT_RATE)/100),0) as FEE

# /* 메인 테이블(CAR_RENTAL_COMPANY_CAR) 에서 CAR_TYPE이 '세단', 'SUV'인 것만 추출 */
# from 
# (select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('세단', 'SUV')) as A

# /* 조인 테이블(CAR_RENTAL_COMPANY_DISCOUNT_PLAN) 에서 DURATION_TYPE이 '30일 이상' 인 것만 추출 */
#     left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as B 
#         on A.CAR_TYPE = B.CAR_TYPE and DURATION_TYPE = '30일 이상'

# /* 최종 테이블에서 START_DATE와 END_DATE 사이에 "2022-11-01" 또는 "2022-11-31"가 포함되지 않는 CAR_ID 행을 선택 */
# where CAR_ID not in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         where ("2022-11-01" between START_DATE and END_DATE)
#         or ("2022-11-31" between START_DATE and END_DATE)) 

# /* CAR_ID 그룹화 (혹은 group by 대신 최종 테이블의 컬럼 선택 시 distinct로 대체 가능) */
# group by CAR_ID

# /* CAR_ID 그룹 중 FEE 가 500,000원 이상 2,000,000원 이하인 그룹 선택 */
# having FEE >= 500000 and FEE < 2000000

# /* FEE 기준 내림차순 -> CAR_TYPE 기준 오름차순 -> A.CAR_ID 기준 내림차순 */
# order by FEE desc, A.CAR_TYPE, A.CAR_ID desc


# SELECT A.CAR_ID, A.CAR_TYPE, ROUND(DAILY_FEE*30*(1-DISCOUNT_RATE/100),0) as FEE
# FROM (SELECT * FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE IN ('세단', 'SUV')) AS A
# LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS B
# ON A.CAR_TYPE = B.CAR_TYPE AND DURATION_TYPE = '30일 이상'
# WHERE CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#                     WHERE ("2022-11-01" BETWEEN START_DATE AND END_DATE)
#                     OR("2022-11-30" BETWEEN START_DATE AND END_DATE))
# GROUP BY CAR_ID
# HAVING FEE >= 500000 AND FEE < 2000000
# ORDER BY FEE DESC, A.CAR_TYPE, A.CAR_ID DESC