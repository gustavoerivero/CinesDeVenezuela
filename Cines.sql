PGDMP     (    (                x            CinesVenezuela    12.1    12.0 T    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24579    CinesVenezuela    DATABASE     �   CREATE DATABASE "CinesVenezuela" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Bolivarian Republic of Venezuela.1252' LC_CTYPE = 'Spanish_Bolivarian Republic of Venezuela.1252';
     DROP DATABASE "CinesVenezuela";
                postgres    false            �            1259    24648    Cargo    TABLE     �   CREATE TABLE public."Cargo" (
    "Codigo" character varying(10) NOT NULL,
    "Descripcion" character varying(10) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Cargo";
       public         heap    postgres    false            �            1259    24598    Ciudad    TABLE     �   CREATE TABLE public."Ciudad" (
    "Codigo" character varying(10) NOT NULL,
    "Nombre" character varying(10) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Ciudad";
       public         heap    postgres    false            �            1259    24744    Cliente    TABLE     �  CREATE TABLE public."Cliente" (
    "Cedula" character varying(10) NOT NULL,
    "Nombre" character varying(100) NOT NULL,
    "Apellido" character varying(100) NOT NULL,
    "Direccion" character varying(255) NOT NULL,
    "Correo" character varying(255) NOT NULL,
    "Telefono" numeric(10,0) NOT NULL,
    "FechaNacimiento" date NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Cliente";
       public         heap    postgres    false            �            1259    24688    Dia    TABLE     �   CREATE TABLE public."Dia" (
    "Codigo" character varying(10) NOT NULL,
    "Tipo" character varying(1) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Dia";
       public         heap    postgres    false            �            1259    24766    Empleado    TABLE       CREATE TABLE public."Empleado" (
    "Cedula" character varying(10) NOT NULL,
    "CargoCodigo" character varying(10) NOT NULL,
    "SucursalCodigo" character varying(10) NOT NULL,
    "Nombre" character varying(100) NOT NULL,
    "Apellido" character varying(100) NOT NULL,
    "Telefono" numeric(19,0) NOT NULL,
    "Direccion" character varying(255) NOT NULL,
    "FechaNacimiento" date NOT NULL,
    "FechaIngreso" date NOT NULL,
    "Correo" character varying(255) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Empleado";
       public         heap    postgres    false            �            1259    24590    Empresa    TABLE     	  CREATE TABLE public."Empresa" (
    "Codigo" character varying(10) NOT NULL,
    "Nombre" character varying(50) NOT NULL,
    "Descripcion" character varying(255) NOT NULL,
    "Correo" character varying(255) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Empresa";
       public         heap    postgres    false            �            1259    24761    Factura    TABLE     �  CREATE TABLE public."Factura" (
    "Codigo" character varying(10) NOT NULL,
    "EmpleadoCedula" character varying(10) NOT NULL,
    "ClienteCedula" character varying(10) NOT NULL,
    "EmpleadoSucursalCod" character varying(10) NOT NULL,
    "FechaCompra" date NOT NULL,
    "Monto" double precision NOT NULL,
    "Iva" double precision NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Factura";
       public         heap    postgres    false            �            1259    24724    Funcion    TABLE     �   CREATE TABLE public."Funcion" (
    "Codigo" character varying NOT NULL,
    "HorarioCodigo" character varying(10) NOT NULL,
    "PeliculaCodigo" character varying(10) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Funcion";
       public         heap    postgres    false            �            1259    24848 	   Golosinas    TABLE     #  CREATE TABLE public."Golosinas" (
    "Codigo" character varying(10) NOT NULL,
    "Nombre" character varying(100) NOT NULL,
    "Descripcion" character varying(255) NOT NULL,
    "Costo" double precision NOT NULL,
    "Stock" integer NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Golosinas";
       public         heap    postgres    false            �            1259    24693    Hora    TABLE     �   CREATE TABLE public."Hora" (
    "Codigo" character varying(10) NOT NULL,
    "HoraInicio" time(5) without time zone NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Hora";
       public         heap    postgres    false            �            1259    24683    Horario    TABLE     �   CREATE TABLE public."Horario" (
    "Codigo" character varying(10) NOT NULL,
    "DiaCodigo" character varying(10) NOT NULL,
    "HoraCodigo" character varying(10) NOT NULL,
    "SalaCodigo" character varying(10) NOT NULL
);
    DROP TABLE public."Horario";
       public         heap    postgres    false            �            1259    24716    Pelicula    TABLE     b  CREATE TABLE public."Pelicula" (
    "Codigo" character varying(10) NOT NULL,
    "Nombre" character varying(255) NOT NULL,
    "Sipnosis" character varying(255) NOT NULL,
    "Duracion" time(5) without time zone NOT NULL,
    "Tipo" character varying(1) NOT NULL,
    "Clasificacion" character varying(1) NOT NULL,
    "Estado" character(1) NOT NULL
);
    DROP TABLE public."Pelicula";
       public         heap    postgres    false            �            1259    24673    Sala    TABLE     �   CREATE TABLE public."Sala" (
    "Codigo" character varying(10) NOT NULL,
    "SucursalCodigo" character varying(10) NOT NULL,
    "Fila" integer NOT NULL,
    "Columna" integer NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Sala";
       public         heap    postgres    false            �            1259    24628    Sucursal    TABLE     i  CREATE TABLE public."Sucursal" (
    "Codigo" character varying(10) NOT NULL,
    "EmpresaCodigo" character varying(10) NOT NULL,
    "CiudadCodigo" character varying(10) NOT NULL,
    "Nombre" character varying(255) NOT NULL,
    "Direccion" character varying(255) NOT NULL,
    "Telefono" numeric(19,0) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Sucursal";
       public         heap    postgres    false            �            1259    24792    Ticket    TABLE     �   CREATE TABLE public."Ticket" (
    "Codigo" character varying(10) NOT NULL,
    "FacturaCodigo" character varying(10) NOT NULL,
    "Estado" character varying(1) NOT NULL
);
    DROP TABLE public."Ticket";
       public         heap    postgres    false            �            1259    24803    TicketFuncion    TABLE     ;  CREATE TABLE public."TicketFuncion" (
    "TicketCodigo" character varying(10) NOT NULL,
    "FuncionCodigo" character varying(10) NOT NULL,
    "Butaca" character varying(100) NOT NULL,
    "Tipo" character varying(1) NOT NULL,
    "Precio" double precision NOT NULL,
    "Estado" character varying(1) NOT NULL
);
 #   DROP TABLE public."TicketFuncion";
       public         heap    postgres    false            �            1259    24859    TicketGolosinas    TABLE     �   CREATE TABLE public."TicketGolosinas" (
    "TicketCodigo" character varying(10) NOT NULL,
    "GolosinasCodigo" character varying(10) NOT NULL,
    "Cantidad" integer NOT NULL
);
 %   DROP TABLE public."TicketGolosinas";
       public         heap    postgres    false            �          0    24648    Cargo 
   TABLE DATA           D   COPY public."Cargo" ("Codigo", "Descripcion", "Estado") FROM stdin;
    public          postgres    false    205   cj       �          0    24598    Ciudad 
   TABLE DATA           @   COPY public."Ciudad" ("Codigo", "Nombre", "Estado") FROM stdin;
    public          postgres    false    203   �j       �          0    24744    Cliente 
   TABLE DATA           �   COPY public."Cliente" ("Cedula", "Nombre", "Apellido", "Direccion", "Correo", "Telefono", "FechaNacimiento", "Estado") FROM stdin;
    public          postgres    false    212   �j       �          0    24688    Dia 
   TABLE DATA           ;   COPY public."Dia" ("Codigo", "Tipo", "Estado") FROM stdin;
    public          postgres    false    208   �j       �          0    24766    Empleado 
   TABLE DATA           �   COPY public."Empleado" ("Cedula", "CargoCodigo", "SucursalCodigo", "Nombre", "Apellido", "Telefono", "Direccion", "FechaNacimiento", "FechaIngreso", "Correo", "Estado") FROM stdin;
    public          postgres    false    214   �j                 0    24590    Empresa 
   TABLE DATA           Z   COPY public."Empresa" ("Codigo", "Nombre", "Descripcion", "Correo", "Estado") FROM stdin;
    public          postgres    false    202   �j       �          0    24761    Factura 
   TABLE DATA           �   COPY public."Factura" ("Codigo", "EmpleadoCedula", "ClienteCedula", "EmpleadoSucursalCod", "FechaCompra", "Monto", "Iva", "Estado") FROM stdin;
    public          postgres    false    213   k       �          0    24724    Funcion 
   TABLE DATA           Z   COPY public."Funcion" ("Codigo", "HorarioCodigo", "PeliculaCodigo", "Estado") FROM stdin;
    public          postgres    false    211   .k       �          0    24848 	   Golosinas 
   TABLE DATA           d   COPY public."Golosinas" ("Codigo", "Nombre", "Descripcion", "Costo", "Stock", "Estado") FROM stdin;
    public          postgres    false    217   Kk       �          0    24693    Hora 
   TABLE DATA           B   COPY public."Hora" ("Codigo", "HoraInicio", "Estado") FROM stdin;
    public          postgres    false    209   hk       �          0    24683    Horario 
   TABLE DATA           V   COPY public."Horario" ("Codigo", "DiaCodigo", "HoraCodigo", "SalaCodigo") FROM stdin;
    public          postgres    false    207   �k       �          0    24716    Pelicula 
   TABLE DATA           s   COPY public."Pelicula" ("Codigo", "Nombre", "Sipnosis", "Duracion", "Tipo", "Clasificacion", "Estado") FROM stdin;
    public          postgres    false    210   �k       �          0    24673    Sala 
   TABLE DATA           Y   COPY public."Sala" ("Codigo", "SucursalCodigo", "Fila", "Columna", "Estado") FROM stdin;
    public          postgres    false    206   �k       �          0    24628    Sucursal 
   TABLE DATA           |   COPY public."Sucursal" ("Codigo", "EmpresaCodigo", "CiudadCodigo", "Nombre", "Direccion", "Telefono", "Estado") FROM stdin;
    public          postgres    false    204   �k       �          0    24792    Ticket 
   TABLE DATA           G   COPY public."Ticket" ("Codigo", "FacturaCodigo", "Estado") FROM stdin;
    public          postgres    false    215   �k       �          0    24803    TicketFuncion 
   TABLE DATA           p   COPY public."TicketFuncion" ("TicketCodigo", "FuncionCodigo", "Butaca", "Tipo", "Precio", "Estado") FROM stdin;
    public          postgres    false    216   l       �          0    24859    TicketGolosinas 
   TABLE DATA           Z   COPY public."TicketGolosinas" ("TicketCodigo", "GolosinasCodigo", "Cantidad") FROM stdin;
    public          postgres    false    218   3l       �
           2606    24652    Cargo Cargo_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Cargo"
    ADD CONSTRAINT "Cargo_pkey" PRIMARY KEY ("Codigo");
 >   ALTER TABLE ONLY public."Cargo" DROP CONSTRAINT "Cargo_pkey";
       public            postgres    false    205            �
           2606    24602    Ciudad Ciudad_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Ciudad"
    ADD CONSTRAINT "Ciudad_pkey" PRIMARY KEY ("Codigo");
 @   ALTER TABLE ONLY public."Ciudad" DROP CONSTRAINT "Ciudad_pkey";
       public            postgres    false    203            �
           2606    24751    Cliente Cliente_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY ("Cedula");
 B   ALTER TABLE ONLY public."Cliente" DROP CONSTRAINT "Cliente_pkey";
       public            postgres    false    212            �
           2606    24692    Dia Dia_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."Dia"
    ADD CONSTRAINT "Dia_pkey" PRIMARY KEY ("Codigo");
 :   ALTER TABLE ONLY public."Dia" DROP CONSTRAINT "Dia_pkey";
       public            postgres    false    208            �
           2606    24896    Empleado Empleado_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Empleado"
    ADD CONSTRAINT "Empleado_pkey" PRIMARY KEY ("Cedula");
 D   ALTER TABLE ONLY public."Empleado" DROP CONSTRAINT "Empleado_pkey";
       public            postgres    false    214            �
           2606    24597    Empresa Empresa_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Empresa"
    ADD CONSTRAINT "Empresa_pkey" PRIMARY KEY ("Codigo");
 B   ALTER TABLE ONLY public."Empresa" DROP CONSTRAINT "Empresa_pkey";
       public            postgres    false    202            �
           2606    24765    Factura Factura_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Factura"
    ADD CONSTRAINT "Factura_pkey" PRIMARY KEY ("Codigo");
 B   ALTER TABLE ONLY public."Factura" DROP CONSTRAINT "Factura_pkey";
       public            postgres    false    213            �
           2606    24731    Funcion Funcion_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Funcion"
    ADD CONSTRAINT "Funcion_pkey" PRIMARY KEY ("Codigo");
 B   ALTER TABLE ONLY public."Funcion" DROP CONSTRAINT "Funcion_pkey";
       public            postgres    false    211            �
           2606    24852    Golosinas Golosinas_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public."Golosinas"
    ADD CONSTRAINT "Golosinas_pkey" PRIMARY KEY ("Codigo");
 F   ALTER TABLE ONLY public."Golosinas" DROP CONSTRAINT "Golosinas_pkey";
       public            postgres    false    217            �
           2606    24697    Hora Hora_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Hora"
    ADD CONSTRAINT "Hora_pkey" PRIMARY KEY ("Codigo");
 <   ALTER TABLE ONLY public."Hora" DROP CONSTRAINT "Hora_pkey";
       public            postgres    false    209            �
           2606    24687    Horario Horario_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Horario"
    ADD CONSTRAINT "Horario_pkey" PRIMARY KEY ("Codigo");
 B   ALTER TABLE ONLY public."Horario" DROP CONSTRAINT "Horario_pkey";
       public            postgres    false    207            �
           2606    24723    Pelicula Pelicula_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Pelicula"
    ADD CONSTRAINT "Pelicula_pkey" PRIMARY KEY ("Codigo");
 D   ALTER TABLE ONLY public."Pelicula" DROP CONSTRAINT "Pelicula_pkey";
       public            postgres    false    210            �
           2606    24677    Sala Sala_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Sala"
    ADD CONSTRAINT "Sala_pkey" PRIMARY KEY ("Codigo");
 <   ALTER TABLE ONLY public."Sala" DROP CONSTRAINT "Sala_pkey";
       public            postgres    false    206            �
           2606    24807     TicketFuncion TicketFuncion_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public."TicketFuncion"
    ADD CONSTRAINT "TicketFuncion_pkey" PRIMARY KEY ("TicketCodigo");
 N   ALTER TABLE ONLY public."TicketFuncion" DROP CONSTRAINT "TicketFuncion_pkey";
       public            postgres    false    216            �
           2606    24796    Ticket Ticket_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT "Ticket_pkey" PRIMARY KEY ("Codigo");
 @   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT "Ticket_pkey";
       public            postgres    false    215            �
           2606    24635    Sucursal sucursal_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Sucursal"
    ADD CONSTRAINT sucursal_pkey PRIMARY KEY ("Codigo");
 B   ALTER TABLE ONLY public."Sucursal" DROP CONSTRAINT sucursal_pkey;
       public            postgres    false    204            �
           1259    24785    fki_CargoCodigo    INDEX     Q   CREATE INDEX "fki_CargoCodigo" ON public."Empleado" USING btree ("CargoCodigo");
 %   DROP INDEX public."fki_CargoCodigo";
       public            postgres    false    214            �
           1259    24647    fki_CiudadCodigo    INDEX     S   CREATE INDEX "fki_CiudadCodigo" ON public."Sucursal" USING btree ("CiudadCodigo");
 &   DROP INDEX public."fki_CiudadCodigo";
       public            postgres    false    204            �
           1259    24791    fki_ClienteCedula    INDEX     T   CREATE INDEX "fki_ClienteCedula" ON public."Factura" USING btree ("ClienteCedula");
 '   DROP INDEX public."fki_ClienteCedula";
       public            postgres    false    213            �
           1259    24703    fki_DiaCodigo    INDEX     L   CREATE INDEX "fki_DiaCodigo" ON public."Horario" USING btree ("DiaCodigo");
 #   DROP INDEX public."fki_DiaCodigo";
       public            postgres    false    207            �
           1259    24903    fki_EmpleadoCedula    INDEX     V   CREATE INDEX "fki_EmpleadoCedula" ON public."Factura" USING btree ("EmpleadoCedula");
 (   DROP INDEX public."fki_EmpleadoCedula";
       public            postgres    false    213            �
           1259    24641    fki_EmpresaCodigo    INDEX     U   CREATE INDEX "fki_EmpresaCodigo" ON public."Sucursal" USING btree ("EmpresaCodigo");
 '   DROP INDEX public."fki_EmpresaCodigo";
       public            postgres    false    204            �
           1259    24802    fki_FacturaCodigo    INDEX     S   CREATE INDEX "fki_FacturaCodigo" ON public."Ticket" USING btree ("FacturaCodigo");
 '   DROP INDEX public."fki_FacturaCodigo";
       public            postgres    false    215            �
           1259    24818    fki_FuncionCodigo    INDEX     Z   CREATE INDEX "fki_FuncionCodigo" ON public."TicketFuncion" USING btree ("FuncionCodigo");
 '   DROP INDEX public."fki_FuncionCodigo";
       public            postgres    false    216            �
           1259    24867    fki_GolosinasCodigo    INDEX     `   CREATE INDEX "fki_GolosinasCodigo" ON public."TicketGolosinas" USING btree ("GolosinasCodigo");
 )   DROP INDEX public."fki_GolosinasCodigo";
       public            postgres    false    218            �
           1259    24709    fki_HoraCodigo    INDEX     N   CREATE INDEX "fki_HoraCodigo" ON public."Horario" USING btree ("HoraCodigo");
 $   DROP INDEX public."fki_HoraCodigo";
       public            postgres    false    207            �
           1259    24737    fki_HorarioCodigo    INDEX     T   CREATE INDEX "fki_HorarioCodigo" ON public."Funcion" USING btree ("HorarioCodigo");
 '   DROP INDEX public."fki_HorarioCodigo";
       public            postgres    false    211            �
           1259    24743    fki_PeliculaCodigo    INDEX     V   CREATE INDEX "fki_PeliculaCodigo" ON public."Funcion" USING btree ("PeliculaCodigo");
 (   DROP INDEX public."fki_PeliculaCodigo";
       public            postgres    false    211            �
           1259    24715    fki_SalaCodigo    INDEX     N   CREATE INDEX "fki_SalaCodigo" ON public."Horario" USING btree ("SalaCodigo");
 $   DROP INDEX public."fki_SalaCodigo";
       public            postgres    false    207            �
           1259    24873    fki_TicketCodigo    INDEX     Z   CREATE INDEX "fki_TicketCodigo" ON public."TicketGolosinas" USING btree ("TicketCodigo");
 &   DROP INDEX public."fki_TicketCodigo";
       public            postgres    false    218            �
           2606    24780    Empleado CargoCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Empleado"
    ADD CONSTRAINT "CargoCodigo" FOREIGN KEY ("CargoCodigo") REFERENCES public."Cargo"("Codigo");
 B   ALTER TABLE ONLY public."Empleado" DROP CONSTRAINT "CargoCodigo";
       public          postgres    false    2764    214    205            �
           2606    24642    Sucursal CiudadCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Sucursal"
    ADD CONSTRAINT "CiudadCodigo" FOREIGN KEY ("CiudadCodigo") REFERENCES public."Ciudad"("Codigo");
 C   ALTER TABLE ONLY public."Sucursal" DROP CONSTRAINT "CiudadCodigo";
       public          postgres    false    203    2758    204            �
           2606    24786    Factura ClienteCedula    FK CONSTRAINT     �   ALTER TABLE ONLY public."Factura"
    ADD CONSTRAINT "ClienteCedula" FOREIGN KEY ("ClienteCedula") REFERENCES public."Cliente"("Cedula");
 C   ALTER TABLE ONLY public."Factura" DROP CONSTRAINT "ClienteCedula";
       public          postgres    false    212    213    2783            �
           2606    24698    Horario DiaCodigo    FK CONSTRAINT     ~   ALTER TABLE ONLY public."Horario"
    ADD CONSTRAINT "DiaCodigo" FOREIGN KEY ("DiaCodigo") REFERENCES public."Dia"("Codigo");
 ?   ALTER TABLE ONLY public."Horario" DROP CONSTRAINT "DiaCodigo";
       public          postgres    false    2773    207    208            �
           2606    24898    Factura EmpleadoCedula    FK CONSTRAINT     �   ALTER TABLE ONLY public."Factura"
    ADD CONSTRAINT "EmpleadoCedula" FOREIGN KEY ("EmpleadoCedula") REFERENCES public."Empleado"("Cedula") NOT VALID;
 D   ALTER TABLE ONLY public."Factura" DROP CONSTRAINT "EmpleadoCedula";
       public          postgres    false    214    2789    213            �
           2606    24636    Sucursal EmpresaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Sucursal"
    ADD CONSTRAINT "EmpresaCodigo" FOREIGN KEY ("EmpresaCodigo") REFERENCES public."Empresa"("Codigo");
 D   ALTER TABLE ONLY public."Sucursal" DROP CONSTRAINT "EmpresaCodigo";
       public          postgres    false    204    202    2756            �
           2606    24797    Ticket FacturaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Ticket"
    ADD CONSTRAINT "FacturaCodigo" FOREIGN KEY ("FacturaCodigo") REFERENCES public."Factura"("Codigo");
 B   ALTER TABLE ONLY public."Ticket" DROP CONSTRAINT "FacturaCodigo";
       public          postgres    false    213    215    2785            �
           2606    24813    TicketFuncion FuncionCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."TicketFuncion"
    ADD CONSTRAINT "FuncionCodigo" FOREIGN KEY ("FuncionCodigo") REFERENCES public."Funcion"("Codigo");
 I   ALTER TABLE ONLY public."TicketFuncion" DROP CONSTRAINT "FuncionCodigo";
       public          postgres    false    216    2779    211            �
           2606    24862    TicketGolosinas GolosinasCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."TicketGolosinas"
    ADD CONSTRAINT "GolosinasCodigo" FOREIGN KEY ("GolosinasCodigo") REFERENCES public."Golosinas"("Codigo");
 M   ALTER TABLE ONLY public."TicketGolosinas" DROP CONSTRAINT "GolosinasCodigo";
       public          postgres    false    218    217    2798            �
           2606    24704    Horario HoraCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Horario"
    ADD CONSTRAINT "HoraCodigo" FOREIGN KEY ("HoraCodigo") REFERENCES public."Hora"("Codigo");
 @   ALTER TABLE ONLY public."Horario" DROP CONSTRAINT "HoraCodigo";
       public          postgres    false    209    2775    207            �
           2606    24732    Funcion HorarioCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Funcion"
    ADD CONSTRAINT "HorarioCodigo" FOREIGN KEY ("HorarioCodigo") REFERENCES public."Horario"("Codigo");
 C   ALTER TABLE ONLY public."Funcion" DROP CONSTRAINT "HorarioCodigo";
       public          postgres    false    211    207    2768            �
           2606    24738    Funcion PeliculaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Funcion"
    ADD CONSTRAINT "PeliculaCodigo" FOREIGN KEY ("PeliculaCodigo") REFERENCES public."Pelicula"("Codigo");
 D   ALTER TABLE ONLY public."Funcion" DROP CONSTRAINT "PeliculaCodigo";
       public          postgres    false    210    2777    211            �
           2606    24710    Horario SalaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Horario"
    ADD CONSTRAINT "SalaCodigo" FOREIGN KEY ("SalaCodigo") REFERENCES public."Sala"("Codigo");
 @   ALTER TABLE ONLY public."Horario" DROP CONSTRAINT "SalaCodigo";
       public          postgres    false    2766    207    206            �
           2606    24678    Sala SucursalCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Sala"
    ADD CONSTRAINT "SucursalCodigo" FOREIGN KEY ("SucursalCodigo") REFERENCES public."Sucursal"("Codigo");
 A   ALTER TABLE ONLY public."Sala" DROP CONSTRAINT "SucursalCodigo";
       public          postgres    false    204    206    2762            �
           2606    24808    TicketFuncion TicketCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."TicketFuncion"
    ADD CONSTRAINT "TicketCodigo" FOREIGN KEY ("TicketCodigo") REFERENCES public."Ticket"("Codigo");
 H   ALTER TABLE ONLY public."TicketFuncion" DROP CONSTRAINT "TicketCodigo";
       public          postgres    false    216    2792    215                        2606    24868    TicketGolosinas TicketCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public."TicketGolosinas"
    ADD CONSTRAINT "TicketCodigo" FOREIGN KEY ("TicketCodigo") REFERENCES public."Ticket"("Codigo");
 J   ALTER TABLE ONLY public."TicketGolosinas" DROP CONSTRAINT "TicketCodigo";
       public          postgres    false    2792    218    215            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �            x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     