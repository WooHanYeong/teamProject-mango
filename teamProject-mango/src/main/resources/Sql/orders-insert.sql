--test data 1(ALL DATA)


INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 관악구', 'CJ대한통운', '우한영', '010-3333-4442', 'why3795');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (10000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '결제완료', 'why3795');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (3, order_item_no_seq.nextval, order_no_seq.currval, 10);

INSERT INTO COUPON (COUPON_DISCOUNT, COUPON_EXPIRATION_DATE, COUPON_IS_USED, COUPON_ID, CREATED_AT, ORDER_ID, UPDATED_AT, COUPON_CODE, COUPON_NAME, COUPON_TYPE, USER_ID) 
values (10.0, TO_DATE('2023-10-30', 'YYYY-MM-DD'), 0, coupon_coupon_no_seq.nextval, SYSTIMESTAMP, order_no_seq.currval, SYSTIMESTAMP, '00000001', '회원가입 감사쿠폰', '1개월쿠폰', 'why3795');


--test data 2(ALL DATA)


INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 성동구', '우체국택배', '차경진', '011-2918-3324', 'cgj22');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (20000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송준비중', 'cgj22');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (5, order_item_no_seq.nextval, order_no_seq.currval, 20);

INSERT INTO COUPON (COUPON_DISCOUNT, COUPON_EXPIRATION_DATE, COUPON_IS_USED, COUPON_ID, CREATED_AT, ORDER_ID, UPDATED_AT, COUPON_CODE, COUPON_NAME, COUPON_TYPE, USER_ID) 
values (20.0, TO_DATE('2023-10-30', 'YYYY-MM-DD'), 0, coupon_coupon_no_seq.nextval, SYSTIMESTAMP, order_no_seq.currval, SYSTIMESTAMP, '00000002', '10월 감사제 쿠폰', '3개월쿠폰', 'cgj22');


--test data 3(ALL DATA)


INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 구로구', '한진택배', '이승규', '011-3503-3404', 'lsg33');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id)
values (30000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'lsg33');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (6, order_item_no_seq.nextval, order_no_seq.currval, 30);

INSERT INTO COUPON (COUPON_DISCOUNT, COUPON_EXPIRATION_DATE, COUPON_IS_USED, COUPON_ID, CREATED_AT, ORDER_ID, UPDATED_AT, COUPON_CODE, COUPON_NAME, COUPON_TYPE, USER_ID) 
values (30.0, TO_DATE('2023-10-30', 'YYYY-MM-DD'), 1, coupon_coupon_no_seq.nextval, SYSTIMESTAMP, order_no_seq.currval, SYSTIMESTAMP, '00000003', '망고 많이 먹기 대회 우승쿠폰', '12개월쿠폰', 'lsg33');

--test data 4(ALL DATA EXCEPT COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 송파구', '롯데택배', '문예린', '011-6545-5489', 'myr1109');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (30000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'myr1109');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (3, order_item_no_seq.nextval, order_no_seq.currval, 31);

--test data 5(ALL DATA EXCEPT COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 노원구', '로젠택배', '우수미', '011-4399-3249', 'wsm55');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (40000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송완료', 'wsm55');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (8, order_item_no_seq.nextval, order_no_seq.currval, 32);

--test data 6(ALL DATA EXCEPT COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 양천구', '우체국택배', '마동석', '011-2304-3498', 'rgh66');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (50000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '결제완료', 'rgh66');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (9, order_item_no_seq.nextval, order_no_seq.currval, 33);

--test data 7(ALL DATA EXCEPT COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 강동구', 'CJ대한통운', '유채린', '011-3485-3490', 'ycl77');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id)  
values (60000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송준비중', 'ycl77');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (10, order_item_no_seq.nextval, order_no_seq.currval, 34);

--test data 8(ALL DATA EXCEPT COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 강남구', '로젠택배', '개리', '011-1432-2355', 'kbs88');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (70000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'kbs88');

INSERT INTO ORDER_ITEM (oi_qty, oi_id, order_id, product_no) values (2, order_item_no_seq.nextval, order_no_seq.currval, 35);

--test data 9(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 관악구', 'CJ대한통운', '우한영', '010-3333-4442', 'why3795');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (80000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송완료', 'why3795');

--test data 10(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 성동구', '우체국택배', '차경진', '011-2918-3324', 'cgj22');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (50000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'cgj22');


--test data 11(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 구로구', '한진택배', '이승규', '011-3503-3404', 'lsg33');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (40000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '결제완료', 'lsg33');

--test data 12(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 송파구', '롯데택배', '문예린', '011-6545-5489', 'myr1109');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (30000,SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'myr1109');

--test data 13(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 노원구', '로젠택배', '우수미', '011-4399-3249', 'wsm55');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id)  
values (10000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송완료', 'wsm55');

--test data 14(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 양천구', '우체국택배', '마동석', '011-2304-3498', 'rgh66');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id)  
values (70000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송준비중', 'rgh66');

--test data 15(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 강동구', 'CJ대한통운', '유채린', '011-3485-3490', 'ycl77');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id)  
values (60000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송중', 'ycl77');

--test data 16(ALL DATA EXCEPT ORDER_ITEM,COUPON)

INSERT INTO DELIVERY (DELIVERY_ID, DELIVERY_ADDRESS, DELIVERY_COMPANY, DELIVERY_NAME, DELIVERY_PHONE, USER_ID) 
values (delivery_no_seq.nextval, '서울시 강남구', '로젠택배', '개리', '011-1432-2355', 'kbs88');

INSERT INTO ORDERS (order_price, created_at, delivery_id, order_id, updated_at, order_status, user_id) 
values (80000, SYSTIMESTAMP, delivery_no_seq.currval, order_no_seq.nextval, SYSTIMESTAMP, '배송완료', 'kbs88');

commit;