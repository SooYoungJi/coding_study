SELECT R.ITEM_ID, I.ITEM_NAME
FROM (SELECT ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NULL) R
LEFT JOIN ITEM_INFO I ON R.ITEM_ID = I.ITEM_ID
ORDER BY 1











# -- 코드를 작성해주세요
# SELECT A.ITEM_ID, A.ITEM_NAME
# FROM ITEM_INFO A JOIN ITEM_TREE B ON A.ITEM_ID = B.ITEM_ID
# WHERE B.PARENT_ITEM_ID IS NULL