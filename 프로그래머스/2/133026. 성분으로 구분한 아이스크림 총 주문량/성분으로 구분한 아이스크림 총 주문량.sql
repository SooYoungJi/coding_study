SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS F LEFT JOIN ICECREAM_INFO AS I ON F.FLAVOR = I.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY 2









# -- 코드를 입력하세요
# SELECT I.INGREDIENT_TYPE AS INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
# FROM FIRST_HALF F JOIN ICECREAM_INFO I
# ON F.FLAVOR = I.FLAVOR
# GROUP BY INGREDIENT_TYPE