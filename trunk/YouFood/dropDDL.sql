ALTER TABLE DINNINGROOM DROP FOREIGN KEY FK_DINNINGROOM_RESTAURANT_ID
ALTER TABLE OrderTable DROP FOREIGN KEY FK_OrderTable_TABLE_ID
ALTER TABLE RESTAURANT DROP FOREIGN KEY FK_RESTAURANT_COUNTRY_ID
ALTER TABLE ZONE DROP FOREIGN KEY FK_ZONE_DINNINGROOM_ID
ALTER TABLE TTABLE DROP FOREIGN KEY FK_TTABLE_ZONE_ID
ALTER TABLE ITEM_MENU DROP FOREIGN KEY FK_ITEM_MENU_items_ID
ALTER TABLE ITEM_MENU DROP FOREIGN KEY FK_ITEM_MENU_menus_ID
ALTER TABLE OrderTable_ITEM DROP FOREIGN KEY FK_OrderTable_ITEM_items_ID
ALTER TABLE OrderTable_ITEM DROP FOREIGN KEY FK_OrderTable_ITEM_Order_ID
DROP TABLE COUNTRY
DROP TABLE DINNINGROOM
DROP TABLE ITEM
DROP TABLE MENU
DROP TABLE OrderTable
DROP TABLE RESTAURANT
DROP TABLE ZONE
DROP TABLE TTABLE
DROP TABLE ITEM_MENU
DROP TABLE OrderTable_ITEM
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
