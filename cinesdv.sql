PGDMP         .                x            cinesdv    12.3    12.3 a    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576    cinesdv    DATABASE     �   CREATE DATABASE cinesdv WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Bolivarian Republic of Venezuela.1252' LC_CTYPE = 'Spanish_Bolivarian Republic of Venezuela.1252';
    DROP DATABASE cinesdv;
                postgres    false            �            1259    24577    bloque    TABLE     �   CREATE TABLE public.bloque (
    codigo character varying(10) NOT NULL,
    horainicio time without time zone,
    horafin time without time zone,
    estado character(1)
);
    DROP TABLE public.bloque;
       public         heap    postgres    false            �            1259    24580    ciudad    TABLE     �   CREATE TABLE public.ciudad (
    codigo character varying(10) NOT NULL,
    nombre character varying(20) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.ciudad;
       public         heap    postgres    false            �            1259    24583    cliente    TABLE     �  CREATE TABLE public.cliente (
    cedula character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    direccion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    telefono numeric(10,0) NOT NULL,
    fecha_nacimiento date NOT NULL,
    tipo character varying(1) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    24589    empleado    TABLE     �  CREATE TABLE public.empleado (
    cedula character varying(10) NOT NULL,
    sucursal_codigo character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    telefono numeric(19,0) NOT NULL,
    direccion character varying(255) NOT NULL,
    fecha_nacimiento date NOT NULL,
    fecha_ingreso date NOT NULL,
    correo character varying(255) NOT NULL,
    cargo character varying(30) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.empleado;
       public         heap    postgres    false            �            1259    24595    empresa    TABLE       CREATE TABLE public.empresa (
    codigo character varying(25) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    precio_boleto integer NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.empresa;
       public         heap    postgres    false            �            1259    24601    factura    TABLE     6  CREATE TABLE public.factura (
    codigo character varying(10) NOT NULL,
    empleado_cedula character varying(10) NOT NULL,
    cliente_cedula character varying(10) NOT NULL,
    fecha_compra date NOT NULL,
    monto double precision NOT NULL,
    iva double precision NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.factura;
       public         heap    postgres    false            �            1259    24604    funcion    TABLE     �   CREATE TABLE public.funcion (
    codigo character varying NOT NULL,
    horario_codigo character varying(10) NOT NULL,
    pelicula_codigo character varying(10) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.funcion;
       public         heap    postgres    false            �            1259    24610 	   golosinas    TABLE     �   CREATE TABLE public.golosinas (
    codigo character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion character varying(255) NOT NULL,
    precio double precision NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.golosinas;
       public         heap    postgres    false            �            1259    24613    horario    TABLE       CREATE TABLE public.horario (
    codigo character varying(10) NOT NULL,
    tipo_dia_codigo character varying(10) NOT NULL,
    bloque_codigo character varying(10) NOT NULL,
    sala_codigo character varying(10) NOT NULL,
    fecha date NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.horario;
       public         heap    postgres    false            �            1259    24616    inventario_golosina    TABLE     �   CREATE TABLE public.inventario_golosina (
    "Codigo" character varying(10) NOT NULL,
    "GolosinaCodigo" character varying(10) NOT NULL,
    "SucursarCodigo" character varying(10) NOT NULL,
    "Stock" integer NOT NULL,
    "Estado" "char" NOT NULL
);
 '   DROP TABLE public.inventario_golosina;
       public         heap    postgres    false            �            1259    24619    pelicula    TABLE     n  CREATE TABLE public.pelicula (
    codigo character varying(10) NOT NULL,
    nombre character varying(255) NOT NULL,
    sinopsis character varying NOT NULL,
    duracion time(5) without time zone NOT NULL,
    clasificacion character varying(255) NOT NULL,
    fecha_estreno date NOT NULL,
    genero character varying(200) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.pelicula;
       public         heap    postgres    false            �            1259    24625    rol    TABLE     �   CREATE TABLE public.rol (
    codigo character varying(10) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false            �            1259    24628    sala    TABLE     �   CREATE TABLE public.sala (
    codigo character varying(10) NOT NULL,
    sucursal_codigo character varying(10) NOT NULL,
    fila integer NOT NULL,
    columna integer NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.sala;
       public         heap    postgres    false            �            1259    24631    sucursal    TABLE     E  CREATE TABLE public.sucursal (
    codigo character varying(10) NOT NULL,
    empresa_codigo character varying(25) NOT NULL,
    ciudad_codigo character varying(10) NOT NULL,
    nombre character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    telefono character varying,
    estado character(1)
);
    DROP TABLE public.sucursal;
       public         heap    postgres    false            �            1259    24637    ticket    TABLE     �   CREATE TABLE public.ticket (
    codigo character varying(10) NOT NULL,
    factura_codigo character varying(10) NOT NULL,
    tipo character varying(1) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.ticket;
       public         heap    postgres    false            �            1259    24640    ticket_funcion    TABLE       CREATE TABLE public.ticket_funcion (
    "Codigo" character varying(10) NOT NULL,
    "TicketCodigo" character varying(10) NOT NULL,
    "FuncionCodigo" character varying(10) NOT NULL,
    "Butaca" character varying(100) NOT NULL,
    "Tipo" character varying(1) NOT NULL
);
 "   DROP TABLE public.ticket_funcion;
       public         heap    postgres    false            �            1259    24643    ticket_golosinas    TABLE     �   CREATE TABLE public.ticket_golosinas (
    codigo character varying(10) NOT NULL,
    inventario_gcodigo character varying(10) NOT NULL,
    ticket_codigo character varying(10) NOT NULL,
    cantidad integer NOT NULL
);
 $   DROP TABLE public.ticket_golosinas;
       public         heap    postgres    false            �            1259    24646    tipo_dia    TABLE     �   CREATE TABLE public.tipo_dia (
    codigo character varying(10) NOT NULL,
    dia character varying(10) NOT NULL,
    mes character varying(10) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.tipo_dia;
       public         heap    postgres    false            �            1259    24649    usuario    TABLE     �   CREATE TABLE public.usuario (
    correo character varying(255) NOT NULL,
    empleado_cedula character varying(10),
    rol_codigo character varying(10),
    clave character varying(16) NOT NULL,
    estado "char" NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �          0    24577    bloque 
   TABLE DATA           E   COPY public.bloque (codigo, horainicio, horafin, estado) FROM stdin;
    public          postgres    false    202   z       �          0    24580    ciudad 
   TABLE DATA           8   COPY public.ciudad (codigo, nombre, estado) FROM stdin;
    public          postgres    false    203   fz       �          0    24583    cliente 
   TABLE DATA           x   COPY public.cliente (cedula, nombre, apellido, direccion, correo, telefono, fecha_nacimiento, tipo, estado) FROM stdin;
    public          postgres    false    204   �z       �          0    24589    empleado 
   TABLE DATA           �   COPY public.empleado (cedula, sucursal_codigo, nombre, apellido, telefono, direccion, fecha_nacimiento, fecha_ingreso, correo, cargo, estado) FROM stdin;
    public          postgres    false    205   L�       �          0    24595    empresa 
   TABLE DATA           ]   COPY public.empresa (codigo, nombre, descripcion, correo, precio_boleto, estado) FROM stdin;
    public          postgres    false    206   Ӌ       �          0    24601    factura 
   TABLE DATA           l   COPY public.factura (codigo, empleado_cedula, cliente_cedula, fecha_compra, monto, iva, estado) FROM stdin;
    public          postgres    false    207   c�       �          0    24604    funcion 
   TABLE DATA           R   COPY public.funcion (codigo, horario_codigo, pelicula_codigo, estado) FROM stdin;
    public          postgres    false    208   a�       �          0    24610 	   golosinas 
   TABLE DATA           P   COPY public.golosinas (codigo, nombre, descripcion, precio, estado) FROM stdin;
    public          postgres    false    209   ��       �          0    24613    horario 
   TABLE DATA           e   COPY public.horario (codigo, tipo_dia_codigo, bloque_codigo, sala_codigo, fecha, estado) FROM stdin;
    public          postgres    false    210   ��       �          0    24616    inventario_golosina 
   TABLE DATA           n   COPY public.inventario_golosina ("Codigo", "GolosinaCodigo", "SucursarCodigo", "Stock", "Estado") FROM stdin;
    public          postgres    false    211   )�       �          0    24619    pelicula 
   TABLE DATA           t   COPY public.pelicula (codigo, nombre, sinopsis, duracion, clasificacion, fecha_estreno, genero, estado) FROM stdin;
    public          postgres    false    212   �       �          0    24625    rol 
   TABLE DATA           B   COPY public.rol (codigo, nombre, descripcion, estado) FROM stdin;
    public          postgres    false    213   p�       �          0    24628    sala 
   TABLE DATA           N   COPY public.sala (codigo, sucursal_codigo, fila, columna, estado) FROM stdin;
    public          postgres    false    214   3�       �          0    24631    sucursal 
   TABLE DATA           n   COPY public.sucursal (codigo, empresa_codigo, ciudad_codigo, nombre, direccion, telefono, estado) FROM stdin;
    public          postgres    false    215   ��       �          0    24637    ticket 
   TABLE DATA           F   COPY public.ticket (codigo, factura_codigo, tipo, estado) FROM stdin;
    public          postgres    false    216   ��       �          0    24640    ticket_funcion 
   TABLE DATA           e   COPY public.ticket_funcion ("Codigo", "TicketCodigo", "FuncionCodigo", "Butaca", "Tipo") FROM stdin;
    public          postgres    false    217   b�       �          0    24643    ticket_golosinas 
   TABLE DATA           _   COPY public.ticket_golosinas (codigo, inventario_gcodigo, ticket_codigo, cantidad) FROM stdin;
    public          postgres    false    218   ǭ       �          0    24646    tipo_dia 
   TABLE DATA           <   COPY public.tipo_dia (codigo, dia, mes, estado) FROM stdin;
    public          postgres    false    219   .�       �          0    24649    usuario 
   TABLE DATA           U   COPY public.usuario (correo, empleado_cedula, rol_codigo, clave, estado) FROM stdin;
    public          postgres    false    220   �       �
           2606    24653    ciudad Ciudad_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT "Ciudad_pkey" PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT "Ciudad_pkey";
       public            postgres    false    203            �
           2606    24655    cliente Cliente_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY (cedula);
 @   ALTER TABLE ONLY public.cliente DROP CONSTRAINT "Cliente_pkey";
       public            postgres    false    204            �
           2606    24657    tipo_dia Dia_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tipo_dia
    ADD CONSTRAINT "Dia_pkey" PRIMARY KEY (codigo);
 =   ALTER TABLE ONLY public.tipo_dia DROP CONSTRAINT "Dia_pkey";
       public            postgres    false    219            �
           2606    24659    empleado Empleado_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT "Empleado_pkey" PRIMARY KEY (cedula);
 B   ALTER TABLE ONLY public.empleado DROP CONSTRAINT "Empleado_pkey";
       public            postgres    false    205            �
           2606    32782    empresa Empresa_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT "Empresa_pkey" PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.empresa DROP CONSTRAINT "Empresa_pkey";
       public            postgres    false    206            �
           2606    24663    factura Factura_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "Factura_pkey" PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.factura DROP CONSTRAINT "Factura_pkey";
       public            postgres    false    207            �
           2606    24665    funcion Funcion_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "Funcion_pkey" PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.funcion DROP CONSTRAINT "Funcion_pkey";
       public            postgres    false    208            �
           2606    24667    golosinas Golosinas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.golosinas
    ADD CONSTRAINT "Golosinas_pkey" PRIMARY KEY (codigo);
 D   ALTER TABLE ONLY public.golosinas DROP CONSTRAINT "Golosinas_pkey";
       public            postgres    false    209            �
           2606    24669    bloque Hora_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.bloque
    ADD CONSTRAINT "Hora_pkey" PRIMARY KEY (codigo);
 <   ALTER TABLE ONLY public.bloque DROP CONSTRAINT "Hora_pkey";
       public            postgres    false    202            �
           2606    24671    horario Horario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "Horario_pkey" PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.horario DROP CONSTRAINT "Horario_pkey";
       public            postgres    false    210            �
           2606    24673 +   inventario_golosina InventarioGolosina_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "InventarioGolosina_pkey" PRIMARY KEY ("Codigo");
 W   ALTER TABLE ONLY public.inventario_golosina DROP CONSTRAINT "InventarioGolosina_pkey";
       public            postgres    false    211            �
           2606    24675    pelicula Pelicula_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT "Pelicula_pkey" PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.pelicula DROP CONSTRAINT "Pelicula_pkey";
       public            postgres    false    212            �
           2606    24677    rol Rol_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY (codigo);
 8   ALTER TABLE ONLY public.rol DROP CONSTRAINT "Rol_pkey";
       public            postgres    false    213            �
           2606    24679    sala Sala_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.sala
    ADD CONSTRAINT "Sala_pkey" PRIMARY KEY (codigo);
 :   ALTER TABLE ONLY public.sala DROP CONSTRAINT "Sala_pkey";
       public            postgres    false    214            �
           2606    24681 !   ticket_funcion TicketFuncion_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "TicketFuncion_pkey" PRIMARY KEY ("Codigo");
 M   ALTER TABLE ONLY public.ticket_funcion DROP CONSTRAINT "TicketFuncion_pkey";
       public            postgres    false    217            �
           2606    24683 %   ticket_golosinas TicketGolosinas_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "TicketGolosinas_pkey" PRIMARY KEY (codigo);
 Q   ALTER TABLE ONLY public.ticket_golosinas DROP CONSTRAINT "TicketGolosinas_pkey";
       public            postgres    false    218            �
           2606    24685    ticket Ticket_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT "Ticket_pkey" PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.ticket DROP CONSTRAINT "Ticket_pkey";
       public            postgres    false    216            �
           2606    24687    usuario Usuario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (correo);
 @   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "Usuario_pkey";
       public            postgres    false    220            �
           2606    24689    sucursal sucursal_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT sucursal_pkey PRIMARY KEY (codigo);
 @   ALTER TABLE ONLY public.sucursal DROP CONSTRAINT sucursal_pkey;
       public            postgres    false    215            �
           1259    24690    fki_CiudadCodigo    INDEX     P   CREATE INDEX "fki_CiudadCodigo" ON public.sucursal USING btree (ciudad_codigo);
 &   DROP INDEX public."fki_CiudadCodigo";
       public            postgres    false    215            �
           1259    24691    fki_ClienteCedula    INDEX     Q   CREATE INDEX "fki_ClienteCedula" ON public.factura USING btree (cliente_cedula);
 '   DROP INDEX public."fki_ClienteCedula";
       public            postgres    false    207            �
           1259    24692    fki_DiaCodigo    INDEX     N   CREATE INDEX "fki_DiaCodigo" ON public.horario USING btree (tipo_dia_codigo);
 #   DROP INDEX public."fki_DiaCodigo";
       public            postgres    false    210            �
           1259    24693    fki_EmpleadoCedula    INDEX     S   CREATE INDEX "fki_EmpleadoCedula" ON public.factura USING btree (empleado_cedula);
 (   DROP INDEX public."fki_EmpleadoCedula";
       public            postgres    false    207            �
           1259    32775    fki_EmpresaCodigo    INDEX     R   CREATE INDEX "fki_EmpresaCodigo" ON public.sucursal USING btree (empresa_codigo);
 '   DROP INDEX public."fki_EmpresaCodigo";
       public            postgres    false    215            �
           1259    24695    fki_FacturaCodigo    INDEX     P   CREATE INDEX "fki_FacturaCodigo" ON public.ticket USING btree (factura_codigo);
 '   DROP INDEX public."fki_FacturaCodigo";
       public            postgres    false    216            �
           1259    24696    fki_FuncionCodigo    INDEX     Y   CREATE INDEX "fki_FuncionCodigo" ON public.ticket_funcion USING btree ("FuncionCodigo");
 '   DROP INDEX public."fki_FuncionCodigo";
       public            postgres    false    217            �
           1259    24697    fki_GolosinaCodigo    INDEX     `   CREATE INDEX "fki_GolosinaCodigo" ON public.inventario_golosina USING btree ("GolosinaCodigo");
 (   DROP INDEX public."fki_GolosinaCodigo";
       public            postgres    false    211            �
           1259    24698    fki_HoraCodigo    INDEX     M   CREATE INDEX "fki_HoraCodigo" ON public.horario USING btree (bloque_codigo);
 $   DROP INDEX public."fki_HoraCodigo";
       public            postgres    false    210            �
           1259    24699    fki_HorarioCodigo    INDEX     Q   CREATE INDEX "fki_HorarioCodigo" ON public.funcion USING btree (horario_codigo);
 '   DROP INDEX public."fki_HorarioCodigo";
       public            postgres    false    208            �
           1259    24700    fki_InventarioGCodigo    INDEX     b   CREATE INDEX "fki_InventarioGCodigo" ON public.ticket_golosinas USING btree (inventario_gcodigo);
 +   DROP INDEX public."fki_InventarioGCodigo";
       public            postgres    false    218            �
           1259    24701    fki_PeliculaCodigo    INDEX     S   CREATE INDEX "fki_PeliculaCodigo" ON public.funcion USING btree (pelicula_codigo);
 (   DROP INDEX public."fki_PeliculaCodigo";
       public            postgres    false    208                        1259    24702    fki_RolCodigo    INDEX     I   CREATE INDEX "fki_RolCodigo" ON public.usuario USING btree (rol_codigo);
 #   DROP INDEX public."fki_RolCodigo";
       public            postgres    false    220            �
           1259    24703    fki_SalaCodigo    INDEX     K   CREATE INDEX "fki_SalaCodigo" ON public.horario USING btree (sala_codigo);
 $   DROP INDEX public."fki_SalaCodigo";
       public            postgres    false    210            �
           1259    24704    fki_SucursalCodigo    INDEX     `   CREATE INDEX "fki_SucursalCodigo" ON public.inventario_golosina USING btree ("SucursarCodigo");
 (   DROP INDEX public."fki_SucursalCodigo";
       public            postgres    false    211            �
           1259    24705    fki_TicketCodigo    INDEX     X   CREATE INDEX "fki_TicketCodigo" ON public.ticket_golosinas USING btree (ticket_codigo);
 &   DROP INDEX public."fki_TicketCodigo";
       public            postgres    false    218                       2606    24706    horario BloqueCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "BloqueCodigo" FOREIGN KEY (bloque_codigo) REFERENCES public.bloque(codigo);
 @   ALTER TABLE ONLY public.horario DROP CONSTRAINT "BloqueCodigo";
       public          postgres    false    210    202    2764                       2606    24711    sucursal CiudadCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT "CiudadCodigo" FOREIGN KEY (ciudad_codigo) REFERENCES public.ciudad(codigo);
 A   ALTER TABLE ONLY public.sucursal DROP CONSTRAINT "CiudadCodigo";
       public          postgres    false    215    203    2766                       2606    24716    factura ClienteCedula    FK CONSTRAINT     �   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "ClienteCedula" FOREIGN KEY (cliente_cedula) REFERENCES public.cliente(cedula);
 A   ALTER TABLE ONLY public.factura DROP CONSTRAINT "ClienteCedula";
       public          postgres    false    204    2768    207                       2606    24721    factura EmpleadoCedula    FK CONSTRAINT     �   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "EmpleadoCedula" FOREIGN KEY (empleado_cedula) REFERENCES public.empleado(cedula);
 B   ALTER TABLE ONLY public.factura DROP CONSTRAINT "EmpleadoCedula";
       public          postgres    false    205    2770    207                       2606    24726    usuario EmpleadoCedula    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "EmpleadoCedula" FOREIGN KEY (empleado_cedula) REFERENCES public.empleado(cedula);
 B   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "EmpleadoCedula";
       public          postgres    false    2770    220    205                       2606    32783    sucursal EmpresaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT "EmpresaCodigo" FOREIGN KEY (empresa_codigo) REFERENCES public.empresa(codigo);
 B   ALTER TABLE ONLY public.sucursal DROP CONSTRAINT "EmpresaCodigo";
       public          postgres    false    2772    206    215                       2606    24736    ticket FacturaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT "FacturaCodigo" FOREIGN KEY (factura_codigo) REFERENCES public.factura(codigo);
 @   ALTER TABLE ONLY public.ticket DROP CONSTRAINT "FacturaCodigo";
       public          postgres    false    2774    216    207                       2606    24741    ticket_funcion FuncionCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "FuncionCodigo" FOREIGN KEY ("FuncionCodigo") REFERENCES public.funcion(codigo);
 H   ALTER TABLE ONLY public.ticket_funcion DROP CONSTRAINT "FuncionCodigo";
       public          postgres    false    217    208    2778            	           2606    24746 "   inventario_golosina GolosinaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "GolosinaCodigo" FOREIGN KEY ("GolosinaCodigo") REFERENCES public.golosinas(codigo);
 N   ALTER TABLE ONLY public.inventario_golosina DROP CONSTRAINT "GolosinaCodigo";
       public          postgres    false    211    209    2782                       2606    24751    funcion HorarioCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "HorarioCodigo" FOREIGN KEY (horario_codigo) REFERENCES public.horario(codigo);
 A   ALTER TABLE ONLY public.funcion DROP CONSTRAINT "HorarioCodigo";
       public          postgres    false    210    2784    208                       2606    24756 "   ticket_golosinas InventarioGCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "InventarioGCodigo" FOREIGN KEY (inventario_gcodigo) REFERENCES public.inventario_golosina("Codigo");
 N   ALTER TABLE ONLY public.ticket_golosinas DROP CONSTRAINT "InventarioGCodigo";
       public          postgres    false    218    2789    211                       2606    24761    funcion PeliculaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "PeliculaCodigo" FOREIGN KEY (pelicula_codigo) REFERENCES public.pelicula(codigo);
 B   ALTER TABLE ONLY public.funcion DROP CONSTRAINT "PeliculaCodigo";
       public          postgres    false    208    212    2793                       2606    24766    usuario RolCodigo    FK CONSTRAINT     w   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "RolCodigo" FOREIGN KEY (rol_codigo) REFERENCES public.rol(codigo);
 =   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "RolCodigo";
       public          postgres    false    2795    213    220                       2606    24771    horario SalaCodigo    FK CONSTRAINT     z   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "SalaCodigo" FOREIGN KEY (sala_codigo) REFERENCES public.sala(codigo);
 >   ALTER TABLE ONLY public.horario DROP CONSTRAINT "SalaCodigo";
       public          postgres    false    2797    214    210                       2606    24776    sala SucursalCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.sala
    ADD CONSTRAINT "SucursalCodigo" FOREIGN KEY (sucursal_codigo) REFERENCES public.sucursal(codigo);
 ?   ALTER TABLE ONLY public.sala DROP CONSTRAINT "SucursalCodigo";
       public          postgres    false    214    2801    215            
           2606    24781 "   inventario_golosina SucursalCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "SucursalCodigo" FOREIGN KEY ("SucursarCodigo") REFERENCES public.sucursal(codigo);
 N   ALTER TABLE ONLY public.inventario_golosina DROP CONSTRAINT "SucursalCodigo";
       public          postgres    false    211    2801    215                       2606    24786    empleado SucursalCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT "SucursalCodigo" FOREIGN KEY (sucursal_codigo) REFERENCES public.sucursal(codigo) NOT VALID;
 C   ALTER TABLE ONLY public.empleado DROP CONSTRAINT "SucursalCodigo";
       public          postgres    false    215    2801    205                       2606    24791    ticket_funcion TicketCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "TicketCodigo" FOREIGN KEY ("TicketCodigo") REFERENCES public.ticket(codigo);
 G   ALTER TABLE ONLY public.ticket_funcion DROP CONSTRAINT "TicketCodigo";
       public          postgres    false    2803    217    216                       2606    24796    ticket_golosinas TicketCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "TicketCodigo" FOREIGN KEY (ticket_codigo) REFERENCES public.ticket(codigo) NOT VALID;
 I   ALTER TABLE ONLY public.ticket_golosinas DROP CONSTRAINT "TicketCodigo";
       public          postgres    false    218    2803    216                       2606    24801    horario TipoDiaCodigo    FK CONSTRAINT     �   ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "TipoDiaCodigo" FOREIGN KEY (tipo_dia_codigo) REFERENCES public.tipo_dia(codigo);
 A   ALTER TABLE ONLY public.horario DROP CONSTRAINT "TipoDiaCodigo";
       public          postgres    false    2813    210    219            �   Q   x�s���50�40�20 "N(Ñ�	$e�2�I#Ks�t���2�40�I��J��C�@5Ќ����� �+F��� M_�      �   ^   x�s��50�tJ,*,�,��M-��t�r�q:'%&'��9}��Ip5&��y%�
n�Yp1SΰĜԼ��D���{j^jQb�'W� ɞ C      �   h  x�mVAn�8<3��<�%�-��c�z�� �c3K�	�1߂�`��c���G[MQ��؇Ķ��VuWUw�٢(Kv)����K�N6����N����zz������f^نq�r��x��dQ,f	����-_p��	O2���Jy��lk����Y�_��reI��"E�E>��Y\�\I�s�����}�4#�8I�Ǣ(xJ)�x'3>��<��l{�jˮ����N=���<:�天�QtZ���6���G��Qt�;��Q����9~S̯e;�S N�
�,9��V�i.҄Kר��d�}t���6c�3i���������vm��,D�W���4��B�b�$c�<�"�D�ى��5��?��P�v7���i�;�8�'���º��',�H3�Xh������y��0G?j�t+٥5���<��:4�ow#[� +��[������(�d'����}�).��\�����$�%�PU�E�~�~��ʲ��G%�J:Y+g�F��w�����V�vr?DN�Y��b�r������~�l��-RЊ���Mㅌ�:��Z�{���s_�j5)G�|�q�g^@�$U.HI>�'/A,���� M��V�ru7�F���]����8#����)�E	�d4�L��yfj}�Mu����+t��{U�7FP����o�HyV�!�Y:43�s�)�l�_{�{�������9M�L͈�t[����TʩR>�>	�� �S������9�:v�}TѲڨz3��ub!��|��#[L���3� �d`KIl��P6.+X�j�hٹn�?��mx�)�k��^F�PB���4"�A� 2�7�����a� �ag�}�~7#5��r����37]��(�i���&�a��;Jƥ �S� �tv���YmdS�&nJ�'�e��&SF�h�p�7e�
F)h���|�\�Ný�\��u��Jag�{�N��}b����s��^{�5�gO�c�
��=��w=�g��Ӯ%���m#g���uCчj'��eQ�,G����,���������{&��t� Sv�5�$wK���pz,�x�L��� 8!��� ��<'����+�t��`���Z9D��a9�qm����� [�"{��`�/��ڶ�`9����ǂ��.�5]��f���C���4[8��^��J,�VC4��~`{.@}����v�*mze;p�����l�,�顛����y�d�PJ�ά0�?�Dl��^���(W�Zu�^�!o ���r�4�Wp�k}���3Bޜ]��g ը%k���5�����(D����2�j��Ρʔ���Ь�_�����X���QtL��������1�<�w#� %E�������U�j������5��?�k�V�w��B�{�
5�,�C� �D�6?���G�9I��	��p�Z�\�'�_I��؋`���[�y�a�������tb���d|{��>�X�	Y��{z�\�<��"��!��Ky>�\�I�'�w,P�V.aH�dw����	��604�lih�Yv��ۧ@P���.8��;U�J}� Lt�����,؅E����{@�-��
O݄��|����Sb ��<<�o�ivő�Z����q�'ܯ�39)�@���x��$��      �   w
  x��Y�n�F]�_��V�Ԗ56��!%2�Qb�[e�Y�bS���˿�B�,��h�ќ[�b?`���LNCrW�{��М�,�I��29�X0�s��k��|5�1HX�c������M�f����u-?�&�W�?����s�'+��8J�Y����Qv�"w�����R������B٬ep���"�x�x0��,T�Dp���[���"O�Ă	�t��� �Q��NQx^��ڵ��v)��炰�K,<���Q\�v���f.�ڄs��Z�q1!��$�C���\�wœ<+�,,���2��P�q3!�����j����#�
G�p���D�еnU#T N�Ǳ���e#�[<��O*����|�>
��S�?��ju�G��j�O�Y�q���P:<E�T%M�#�J\G%}�k�;%�hm� ���<)���I�	s�fC�>����6.����i�x��E��֞6s��	�d]kp4�O�j*��Qx%�ZI�*N��"K�� ��qG���a��SiZ݈�p�j�R�Qز�YZx����PK�T+��� \V�8M,�_�\4r-<��F�X|�ퟌ����Ԧ�������9M�'�t�^��<�A8�=~!�`����Y^r��[���K����E�H�(�Ĉ�8jfO�>�y�R�<�_u-�ԅ0�� 8i��E�-�;� �#@`��mx�[p���0?�yO��@}v��?+�HI걜B��e4�y�<ՎKee灓�[a���9o��N4�0p�Oj�!�˓�G:�_�r�Q�h�1
r�E�H�"/��H�j-(�D7�:45��-HT�J	���)�^H�c�{�	�[%g�%c8�����J�B�4D+N��!��R@:P�#�R��R�_�Љ�w��YDV�b*]j���?�.��Co�T��B�1s���M�;����ge�6�v�驮���Y������j�eNn��[�׬t���+F�>�M�Q��u�:]�f-�">��=�͓|�&�e�iM�����ٖ��̲�|��l11L~a����������Np	ֵ�w���4�����y# ��_�(Ӄ���ҵ������Ŗn���}��,9�xV��^��A/*�V��WR?�("8�ֺ�{1��y�,S�Ο��_ҳ=����}�_4 �&l��	߱"��q����v%��m* ��R��}�⃁��(q�rW��{}�"�<Lh
��~� 5�"Z���I��{m�ޅ����";���q0ug�ѣ�eƼo.�"�A'���W=�J���"��gށ�s��;�Xo6��Qw�7d��4��&��氊7h`u�+X��J�d\�x�#�-̬��@�&`���.���v J{�T�KF,6y�E���Ts��Դ_VXe�/�(�%�>��zU�{K���;r�˘'Q�5��&��<=b��r��������8|�:5P�g��b=��pAx'G�<:�Ul�$m�%F+�|�]Ν�F��,�{��%���fm���Ve��&��G�瀪]ͪ�ܝ½h���Z#񗰯��;��4)8o�"��U$�7���ܛGm*�2:0�y��q�̸�_\�9�3)=*<3ZW$��`�e9Hh L�j%��J�9�J
�b��8���hAy׊uꮙ�ZVy��P�P7���{�\���Lw��=��e	W^Pk{
�3*Z-�nE�b���f��d�����J�*�GvZy�e2����+*9?�P7dX�F�����}K�~4rC~����L�9]����<��yg-�y�R@'|iX$0�s�N�Ԯ%�@1�;�{䪗Y'�:�d�5�=J`3ҡ�n�o7(�&F[b<��m�.U#v��� �v��5���B��$��坬���*'���&�8N11+��b�MrC�/����mp�-���U˂]�`I���/+��<'���Sl���`M�v���=�R�dx/c�����24�j�����,��V;~6��e'Š\)��ZT��rIy�Oh6�sq>��Cn�?i�1�3B!���*�~�4�%mα�)�#�fDH��MG��4M`�<6E]@pT�x�%n ��:�)0�7���6ؘ����o��a '�����L�M8(��؆�8X,�U#QB�
��1�A�9xg�����i%�m6`���ٻW%�(�!%��y!up+�]r�|EF(ζ���z�0�|ӫȂ��91v)�������$�C@6 L+{�ځf��1X�������_�a��M ֧��)й#f�D5��𾌒@�?HŐ���e�D8*0��"�*&(��E�lTH�Q`�'K��Ϊ�q� �Be[.�D���dl��y � �y�=p��J��$�((p�z3��
)�ئ��) ݦ >� �S�ѯ�Ep��GGQ ,��_	l��� ��G)u3�Z�`�a�\�"]$����Z�E����[�pI��>	����;{TH�3K��b�[�MA z}�v�@�]�>��|��2�^��0����������o�F��xd��t`��1��Kv;�s^�}Ћ����A�����N�4��0�O������ycx�b%�����׹c�p���e�[��/s�`<�
8'����Η���3��@���7o��d��?      �   �   x���50426153׵�t��sVpqUs�s�
u�q�Qp�s��tNLI�KTHIU((ʯLMNμ؜��\؛\��X�������ZU����霙�Z�rH�M���K���435�05�t����� %�(�      �   �   x���Kj�@D���8�[R/���"�?G�=�!dVn���Jz>�w�a���#�5LLv��=��)C%�1�s1�RT���JG��3�%"#r���������H�{"yX��r�8���0���dK�'����ШG\�U�a�9Ma�G�39�X��8<Y�4�(Oj�\����\)l�Xh��6Y���u"J��͍jwDm!��mtUxfX���?L��'5aU�4j���k?_۶�G�qM      �   J   x�s��50����50�p��52�t�r	A�M��0ac��1D�&l6X��M!¦a�!1z\\\  2�      �   �  x�m�Mn�0���S��@ԏ�,S-�ik��Hl)�%��ir� ���G�H�c	�4��㼧����D���Zو"��6�sa��� ɣ��xj�AZ$����n�Ka��l�@CƨH��%��p�c�_Z��[]S���|$�^�c?����3%[Y:Gg���c��S��֝1۲�i
JgQ�:���0�:�E�l�J~T�
��]�����ۯ�$WC�����f@7�����G���'�Wjsy��ג&0M����zk�?�M�\(&�W��W:��Eφ�����p�������5{��K���o/��麘a�p��$1�o�$O�2�fr`���{�J���"���e��6<����.@>�-(=�O��_sX��<w���7j�4 n�e&����-�U��ڲ4��>�Gϧ�,mTq*if�"�"�G�*ZP��"u|�+��&��Ac	K.Ǭ�;�T�6����ЩS�\Z��t"�[�V��)�      �   `   x�u�1
�0D�:{���M"ZF,"�z�s�8���g�1��,��-�,����H�U��I���K�;4@�7lyC���1 ����F�h��	ρ�.Sd)-      �   �   x�U�;�0�ھKPf�M�(P$�����$�q���gv���;���cB��m�9\��=D`�X����o��e��g�
H��d;���h��� �4��RL�/H
����X d]E�\H�����Gq]J@S��H&�3��GĎt7r���_C ��E�^�"7r��L��'���[�
ե��~���)�_���K���y�      �      x��[�rG�<��"��Y�����@�����$ř]�KvUvu�Y����&�7�n����/�x�/ �h�#2� g�l��L�]�������΃�k��^���ښuL&�޼�np��KC��w�u��!Y���X���Μ7�.�jn�Κ���u��l�7���V�7[����z������Ա��t�ش��Ɔ!����ۍK|s0�}�ǌ��xj?������1�u��<���f�7�潍<p�|W�ޚ'�o}����6�޼��0��c�U�3�hֶN��D~v�k�k�ja�C��n|�I�<ti�9xn�{ۙ���h�?<6�,>_��!�p�tim��_p�i|���k�l�c�����QlP�sp�
�>�}���0�/k.F��7������xj5.4X��v�?ҽ���q͏�����0�Z?���]'���Ķ��80L�o��x?���Ň��ۈD�b~`���N��ܽr2;�����;:�����삁p�G�[����vp8bZ��cñy[��!�p�0&��οy��=���+{�Ĝ=�G�u���S�5G�h^Ů��z9����1=������ERg�6H�����#��m�ϯ�՟a��4�C��֥���za{q���G���H�H秸������h)��ظ�w�?F��?��_��!������g�w㋴y��&Ħx�!�*$�C��`F�e*��C�g�qV#�4kS��%�-v�����<b+��F��c�+���� <��2��%�w�����e�b��U��ȸ�=��_?�kl�2��z�q�ǊG��ױ���� �X��/f�T0����n��>��wi�+�t[Z���Wu�Ǩ�����Pv�r��"��Y���l��vj>�%�J%xx����������g�_��c<�7��El]��ɶ���UB��T���I|�Ӱ��!�
��b������qXٶ�VKܢc��?;Vw�ɩ�0!x߭l�^���dF�U�՟��`�Ek������!�ʝ�,�,���\���{,���Wu�5�ݍc���X�
��,}�z`8p����Ҙ��pu�G�`24V��}��"x���\F�}�I�9�C��c�/��I�%�=9��dz�$f���Ex�M.םo:����d�NO�I_��D7�����?�5��.�2��󝠋-HW }�@P>O�x<��<
��9�:T�61k�&E\.�N�Y !kU�V;^�����Y�K��`r
�J�����f���".��ڡ�Q���|�?=�}�F�sfቀ7	��;t�8�Z�#>}�>f����V�#'/O�s�c�@64���^��~��*��\���0���$�[+������*8e���D�� (��1 �"�M�r�⒕�)ޔ�ތ�.(]���M&R���2���Y��{��V�V�J:�JA��fDg�����o`��y2JZ�R���1�
g�S0����յ1�s����0"��3]��%"��9Xs�<�̓X�$�&����<�B��iʍ�O`��%sz�����9=:��eɜO�u�L`� d4-u���E�[����V��?��,O5F��"����vn+0W�\�@
T�)L�J&���n�_�f
�<GF2XH�up���� �!�BB�����]ȥN���h���]�r�ձ)9;7�vBSڅ�3��I��G��e4 �΀�C5���
[HRʃT\㴅�Lp,��L/�"�h��|���ۻױ���A	� ���~m¶�!���k1�'�ܜ�K���?�CC�/�2�Ԉ%g��N
$e/͕��Aގ���y�����?��{��o��|Y��
��نc {:��U�t����Ը�)Z->�'|�ίF�;z�~Ԗ��C�b�����Qh�D(���ގ������8��ҡ�:��$��%���fn����C�3�����N��ήV<;N��Q���9d|���$#����>������fn�}��07�A�]��*���eb�ײ&)�R�jL�����FR|9����%�$5���O+����F������R����/�{���O(D�F��Ԯ�6g	�r�津�������N_X4^�d4�(ϼ����9��bS��fj��j;LJ�#�a'��|>_&���;�z�槈��ng���)��qaɬ#b�?|mV؀3�bD����W�����2K�9$�Y����q1���lǫ�����ɦ,)�J� `I^)�=���L
`+�|��1$��0�>`S�-q����\� F�Lf�������V�����ܜ%���sK�w$�|��C�pNT�"$W�xd�H��b1 �`ӄA�!ݠ���������[���Й+��Q8�����H�O��^r4��ѩ���	��s��UN��B@�RlC�^��T���Wg��G�ݝ=��������ʯ+�Mʛ['{l���F�jWG2%�|�Y� �270d�X�U/1�x��ts�������:*�m��r���0h/RT�f�Q?x�0��{�O<5�Zms�ߩ>��`��IÈV�3`zi@���XQ�(��]�4]J�RJx�
zn�۹y�Bw�VSr�(Gz����:i6 �pL_���c4��R�vY�c�#
� �f%�:��Gf��@P��^�P��5	�-\f�٩JH��H���8K^���]�D:M����cF�%3���\ڎ��2��syX����=����}�����c�jbޛ��Q��`�!3N�1��KK��<1�`�@�q��{��٬Iސ�`hN����G%a�u3O�a�,���Zʔ3����#:T0^�4��P�}p�*ł'�����$�)0Ԭ$F?Y��s]���s��������v,�FI]q�ϲŏ�_�wCg����O�-������gH`�f�g�=٦o�Y��B���F!����|ED��Ӊ� �y�0��e��lÔn2z�($4�bʟ��B�?9eNOf�}���`�C�9�!D6��ج˘6�ۛ�'��K��b:4v ��1_H'0��+�D���Y�)�h'u���*/ÏEw�����B
�ί�߷U�'B[�AIʺV0�}�L�012����p�P��х���)2����Z��p�
bke���"	�@������.�(X�)M�1~��!��{'yf��%�F0Xvx�+��o�jk4�
"
!"8��b��/T!�>�����X�qR^a	�y`���x��زO r�n��B�z	/�]�1�х�V�|�6D�γϔ�j7a����I,Ê����2=H��V�g]S�ݸ	JϮ��wG�_�(�t�}=��tF>�i��`W7g�6*�70���n�R��\����7�s��}�h�;?l1l$���p���u��r�Y�W[U�`���J)���K�y9˾�,��3�� �r�_zA�/�>��Yvz���l��Y�/#z�`���➤�C�L#�=A�ˢF�����"�:�h�%s;�_(J�{퉱r�>�~�c�Cv�';o/?%�JE�6���f��ܟ� �*��a0O"\����'~�;Y����҆H${RQ���k��@@\n�l�%���N5:���m����R䊍����#���Q���^�sYI���J��V�Ǝ��E����w������*����8�\~�%�h5���~ys��XzO�~�-p��\���%"*G���I��� 	�m[;9�n8��ya� �����0Q?
����u�aAv�,�-e�c�/E�a�
6*J�U������m��c�F�٠�o�&(��)Ġ�e�E���W�uzcH���~��WT_���B��랛�����9��!E�{'sU6o�����z��Q��G��8�*�=|�#�w��ك��<�AZ;�[��#�$��)��t?0~�z�'&��ѻRໝB��ܩZ�%a��z/a�[����E��9Y]�u�`�@�0Ln�g��?�(gkl����*�2��(�&]w��q�N���G�r� k @A�q���c�Z<{j� �h
E"�o��i O  n��	��Q*Qy�tM����o����W���e����F��t�5���9����,�[]�aԬ�xEC�r��o���&	R������g$�#G!t�V�`�А�S B@9�Y@	6��T��|�;��=
��%I��=�)dMT Y=Sf�*g��aqU]�K�fbc��àw(��%�G����T^��7�ݧ9c7��c��ҥv�������H6��P0��?�`�Ne�I�g��� (h��8��Oi6��۸�*��
%���ْBd~J%�j��ԛ`K%��f�x�Tn��i�::���T���|����Φ�E5�8{$آq<j}ؚ���U�Z{g�"����ar<_,":~�3,�L8�@�2��d��#��~�ACQ}#7�  9yA������.��r�a�%�_%��խ�]&�YT�|fkݻq{`'~Ӳ#�v���@x��9��튐���i���H8"c�2�ð/ȫc��d�W�z����$��uR<.G�n��>���^�B�N0̆�1oy��d����tI��6cn)��!�����}R~���v� �u���rNX$ �z�F�~$E["qvMe�5] �A�R��t����f:��ҁ$�!VԫLTxSf�@CmE�bw���ܽ����I;�)>���E��4��ވI!�����g��σ�3P���횋i� �خ�J��˰J��Gb^Ͼ_K�p��}����k�d�.��$
��s�^��U�:n����m��r{�B�:�^���ЛW�*�Iĥ��k��5�'sP������p�
z�Ϡ"0lk���]�gA�1.�4�?���&�f�#Z]��N)�=�|\����w3`�dZ-�ޗ6�W�&}g	�n�A��+�ǍC����1v�A�1�`���[�ͪN%����QU��������kKT0��P �(�)�-��H��o���62��2R^��o�x�B0�l�+Y� |�	[�� X<`d*�)�ԇ��.Z���I	@m���Z���X�u��dTG6[	�.6�ɷ<����.����(�UA�t��5�����I�X����,�%�r�H�ZH����B߇�9d�^cՆxoB�ۢ��9&�8�u-��L�����Z�{�7��~b�޻{��UY(/GQ���?/�q��R�]+8�}��r�M�v��IEtv��r8S%^�!ZSk�b5ӇB��,BDe^�N�Cz��ʶ�zDTuV̾�S5����s.��
�ȗ��ݸ���b��Ӟ��r��A������˒N���H�����I��w �}�(@K��"�\n�x� �w�M��ptz�ZFdԙ�z_w�;{f˝���P�&%���5�<P�v�$[UD���
�\�T���lW�,m�P(�K�p�+��3�<v�3q+�����l��q��9ՠ���q`^__$�T�IܲWg�r�%'߻ 'Ev��^��uY��'�I��q����sB��g�u�=)8���¼X,ǡ��3��,c�׆z�B!7�ˍ?�Mڊ3�9�N���o�xI)	#���|��2��e��e�7�_���O+X����(D�p:�.d�{2��%?��4���1?��;S)��u�E��)J��-s^��͵��.1|��ϻ�H�m'��b�h\Ȟ]w�:�z�F@�w�pN��>m�֋l#��'r~��Il����rUly3j�O�D\+Z�l%�k�ўk:�b^?����u������g�+�j��*�]5c�_�ցp����1�n_��u���=���;wa��['��}�\���t6З��r��k.��2��7,�oav a�%e7ꄗ��D�'��P0�7��?���>������훾��,��w�4 P��g_�o+ M�]5�\gvP�:�-�苬�]h�>�*����NT����+�^���I�D�m#��=����܀��r4�,����>�SL�	c��~��ma���ti�9ll��t!��y�)�\���>Z�!۾S.�,���J��,�N�eQw�T����3:��N�i UΓ�hz�����}�$)4�r�e�;w�aec�3 A�*�Zn��2���Qd�I*��R!5���r�z��9�{�N����/��Ю�k�y��7��/��)      �   �   x���;�@D��)|�P� �(�hLv�"m���p~6�� t��yov��h2uK�Ա���E�j�K֊=�U�T�R/�@�hnǐ��Va�Ůg��
��0���{���YWvj�܁ZhBD�'}����l;J@�e��K�[���%���.O_�Ň�� VG�K�
��EQ\��      �   ^   x�M�;�0Й������be�ظ�9h�FX"=�Cz���[�yt�Q��ddY2���f	���V�2��YAS7؞f=f���-�?t�{���.,      �   E  x����n�0�g�)� �AR�d��S	��h�E��B�,(ҥ� ���o��C��~���nb%�bм#ﻟ���vQ\��E�f�(�^����2�$���I#���@n�X)M.���U�
Y�`*M��K($�i�=���IL)�T0�$4�dp�Qx�� e��k0��dj�r�4��ɕ�0������=��C6���� �L��!�����&�)9�\�qG�P�}�sX��>���CG�>i�P��/:���Z++�4�q&�d�a�s1.�Ò[8%i�~[:��Q��M�J��K�I�g�����tI*b~�Kz�x6��1�.��>s`rU�֧.�C�rkZ4�0�Aj������Ioo����&���s�٠��T�bc��siO�|��J��^����Ì�d�{��У��eH.UY9Uy�7�ݒfi:1ޑf=���q�=R���6JT�����PJ��8�:$_ԃ�d&�?0�9�8c�h[�w��geW���H�1K�Y�?:!+��X����A��+�A� ��V�4��/Fx,��b܁�0�|ƕk'aO�����?�/�s      �   \   x�E�;�0�9���c��Խ#�?%<�z��9��	�}�'��shU��`�!ѤB��8H6H1	�j;B��f�~Y�*�~n���kg�@i)Y      �   U   x�=�1� D�z�.v�DK�`l�����Cq�����چ��c��^KB�b��b�"�_�@����(JI��{2�(E��E�2\      �   W   x�5�;�0�9��|ڲ3�.�DL��к�,=Yv���	��i�h!��`�l�l�`�,v2p'p���Y�e�\�c��#���U3!�      �   A   x�5ʱ  ���D Q"Ѱ��)\���Y�(ԡX�C5Ԩ�0��愣:�Ĉ�YDy �      �   �  x�e�Mn�0���)z������"��Yd@�-�b �%Hn՛�H٦mR�W�G�͛7�a�s�6�����Ck\���v��{� �������Z�]��l����w�i>{��l�i(r����6�����U������9�
��C��ٙ��O���j�o]0]e�(�V3�����U�����.��l�p*o"�_\8�Ι�URL�Xze��|0(�~%>�q��ͮ��q�q��Rp��غ�|
����������A* G"p-��;Z�l@/�t��W��`���p/f����Ę0����������zh��V�O�(����o���,k��PQ�5��;�����p-/��ƌe���y�@��5?v�3�
��z�/��M�ՇQʡ�)1��}�9�r�f*^\e6��N��cFiN��0��t�( sͶm��:��T�������8;l���:����a�Z�~�����f+3d�tQj`D̚��<q�3�w����I���	9�ݛ��.�� ��.��"���BK��(��MY�܇3�2�Zӫ]W�4י����"�	���mo���4�Y}����wvw=3av�#\��{�y���ZC&�����Ls�X�ix��e��%��OY��ˋsH,�n)Aq���.��Z.���U��     