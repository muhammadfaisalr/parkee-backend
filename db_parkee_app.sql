PGDMP     	    ,                {         
   parkee_app    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24587 
   parkee_app    DATABASE     �   CREATE DATABASE parkee_app WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE parkee_app;
                postgres    false            �            1259    24606    m_discount_type    TABLE     `   CREATE TABLE public.m_discount_type (
    id bigint NOT NULL,
    type character varying(16)
);
 #   DROP TABLE public.m_discount_type;
       public         heap    postgres    false            �            1259    24596    m_payment_type    TABLE     _   CREATE TABLE public.m_payment_type (
    id bigint NOT NULL,
    name character varying(16)
);
 "   DROP TABLE public.m_payment_type;
       public         heap    postgres    false            �            1259    24616    m_status    TABLE     Y   CREATE TABLE public.m_status (
    id bigint NOT NULL,
    name character varying(16)
);
    DROP TABLE public.m_status;
       public         heap    postgres    false            �            1259    24591    m_vehicle_type    TABLE     �   CREATE TABLE public.m_vehicle_type (
    id bigint NOT NULL,
    code character varying(1),
    name character varying(16),
    price_per_hour bigint
);
 "   DROP TABLE public.m_vehicle_type;
       public         heap    postgres    false            �            1259    24601 	   m_voucher    TABLE     �   CREATE TABLE public.m_voucher (
    id bigint NOT NULL,
    code character varying(16),
    discount_type bigint,
    discount_amount bigint
);
    DROP TABLE public.m_voucher;
       public         heap    postgres    false            �            1259    24611    t_parkee    TABLE     �  CREATE TABLE public.t_parkee (
    id bigint NOT NULL,
    parking_slip character varying(32),
    vehicle_number character varying(10),
    vehicle_type integer,
    payment_method integer,
    check_in_time character varying(64),
    check_out_time character varying(64),
    discount integer,
    discount_amount bigint,
    base_amount bigint,
    total_amount bigint,
    status character varying(1)
);
    DROP TABLE public.t_parkee;
       public         heap    postgres    false            �            1259    24634    t_parkee_seq    SEQUENCE     v   CREATE SEQUENCE public.t_parkee_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.t_parkee_seq;
       public          postgres    false                      0    24606    m_discount_type 
   TABLE DATA           3   COPY public.m_discount_type (id, type) FROM stdin;
    public          postgres    false    217   �                 0    24596    m_payment_type 
   TABLE DATA           2   COPY public.m_payment_type (id, name) FROM stdin;
    public          postgres    false    215   (                 0    24616    m_status 
   TABLE DATA           ,   COPY public.m_status (id, name) FROM stdin;
    public          postgres    false    219   S                 0    24591    m_vehicle_type 
   TABLE DATA           H   COPY public.m_vehicle_type (id, code, name, price_per_hour) FROM stdin;
    public          postgres    false    214   �                 0    24601 	   m_voucher 
   TABLE DATA           M   COPY public.m_voucher (id, code, discount_type, discount_amount) FROM stdin;
    public          postgres    false    216   �                 0    24611    t_parkee 
   TABLE DATA           �   COPY public.t_parkee (id, parking_slip, vehicle_number, vehicle_type, payment_method, check_in_time, check_out_time, discount, discount_amount, base_amount, total_amount, status) FROM stdin;
    public          postgres    false    218   �                   0    0    t_parkee_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.t_parkee_seq', 751, true);
          public          postgres    false    220            �           2606    24610 $   m_discount_type m_discount_type_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.m_discount_type
    ADD CONSTRAINT m_discount_type_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.m_discount_type DROP CONSTRAINT m_discount_type_pkey;
       public            postgres    false    217            |           2606    24600 "   m_payment_type m_payment_type_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.m_payment_type
    ADD CONSTRAINT m_payment_type_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.m_payment_type DROP CONSTRAINT m_payment_type_pkey;
       public            postgres    false    215            �           2606    24620    m_status m_status_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.m_status
    ADD CONSTRAINT m_status_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.m_status DROP CONSTRAINT m_status_pkey;
       public            postgres    false    219            z           2606    24595 "   m_vehicle_type m_vehicle_type_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.m_vehicle_type
    ADD CONSTRAINT m_vehicle_type_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.m_vehicle_type DROP CONSTRAINT m_vehicle_type_pkey;
       public            postgres    false    214            ~           2606    24605    m_voucher m_voucher_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.m_voucher
    ADD CONSTRAINT m_voucher_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.m_voucher DROP CONSTRAINT m_voucher_pkey;
       public            postgres    false    216            �           2606    24615    t_parkee t_parkee_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.t_parkee
    ADD CONSTRAINT t_parkee_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.t_parkee DROP CONSTRAINT t_parkee_pkey;
       public            postgres    false    218               1   x�3�prv�qtw�2��tv�w�2�tv�prt������ Ζ	D            x�3�tv��2������� &z�         %   x�3����p�t�2�SƜ�~.�~�\1z\\\ ��	         =   x�3�����O���4600�2��rK� \c�ΐ��lNsτӉө���� ċ���� łK            x������ � �         �  x�uWK��8]w�%���s��� �I���9BJrU�V�u���H�������{������}���xٴRg5���^ܛ(|��?��AQ���H���K�����:�$T��U+��QNV��CU�����K�����M�T�"ƗHp�P	6z��4�G0�c�}��h�oX�D4�+�"�c�vFT�f?Lta�/�DK�|�-_�)iV��n�@F���/^U�2��Ju�(�%_�a��9�%�g��P���F�6�z*�q�����*]�U���,R����(���m,E�I�UA L"���,�̃F��R��?:қp��?����ܴ��8�1��M�xCixw�z����N��o��KQ4h�~����P`��FPmV��i��KX��D��9��T�~�Vs���44c�ÐC������"N�V��5Z����e_E
�yZ��,�t�Ae?^�JWۈ���Z�e2��ٌ8��֌�(n���֌q�^�n���~'/�ͨ�����t�AR��0z�s�z�aT�io� |�H�����p,�%߶;��C��7#�sDi�g�� �n�������c��V� �9�#͛L��%�,%Ǡl.���U5���3urجO[և6i@�2���&�z��tyk]�\�B��p��K�y����Z��u)dB�~���/��P�������j~�9r��6��!,"�/�jt;�6JI��Œ�`ڏϊ�k�+ڟ{�n���`1����V#0H�ũ�]��8���n(����6.횿wK����\D��L�Nu]Z�A/x���=��Ƭ������Fq �~̞������������Ї��6 �����} A�,�3���2&Y �A{g���Ff�����\�7�;�G�7��������i��=���IK/�
����g�)i�xђ�	�}&���TY�8��<Wʃ!!443���֒�y=��V���М�Y�؉����Zx��P��b��j0_L��]�����bWSט��Q-�����F��6���t����cG�Զ?�bP�a"x1���P-�l��g����<ׅ�7����w@� k���M�a�`����|xk���K��]k�o1����a�2��װ?�X̼{�$w��
��O�A���5m�+�N��5Ң�s� S����5��4������\�R     