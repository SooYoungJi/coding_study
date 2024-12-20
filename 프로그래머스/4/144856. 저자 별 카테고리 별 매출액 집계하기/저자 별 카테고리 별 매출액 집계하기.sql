-- 코드를 입력하세요
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(BS.SALES*B.PRICE) AS TOTAL_SALES
FROM BOOK B LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
    LEFT JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
WHERE DATE_FORMAT(BS.SALES_DATE, "%Y-%m") = "2022-01"
GROUP BY B.CATEGORY, A.AUTHOR_ID
ORDER BY 1, 3 DESC