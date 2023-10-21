--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-10-21 08:42:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS "cinesV";
--
-- TOC entry 4984 (class 1262 OID 16398)
-- Name: cinesV; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "cinesV" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE "cinesV" OWNER TO postgres;

\connect "cinesV"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16399)
-- Name: bloque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bloque (
    codigo character varying(10) NOT NULL,
    horainicio time without time zone,
    horafin time without time zone,
    estado character(1)
);


ALTER TABLE public.bloque OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16402)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    codigo character varying(10) NOT NULL,
    nombre character varying(20) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16405)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
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


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16410)
-- Name: empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleado (
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


ALTER TABLE public.empleado OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16415)
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empresa (
    codigo character varying(25) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    precio_boleto integer NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16420)
-- Name: factura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.factura (
    codigo character varying(10) NOT NULL,
    empleado_cedula character varying(10) NOT NULL,
    cliente_cedula character varying(10) NOT NULL,
    fecha_compra date NOT NULL,
    monto double precision NOT NULL,
    iva double precision NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.factura OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16423)
-- Name: funcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcion (
    codigo character varying NOT NULL,
    horario_codigo character varying(10) NOT NULL,
    pelicula_codigo character varying(10) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.funcion OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16428)
-- Name: golosinas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.golosinas (
    codigo character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion character varying(255) NOT NULL,
    precio double precision NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.golosinas OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16431)
-- Name: horario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.horario (
    codigo character varying(10) NOT NULL,
    tipo_dia_codigo character varying(10) NOT NULL,
    bloque_codigo character varying(10) NOT NULL,
    sala_codigo character varying(10) NOT NULL,
    fecha date NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.horario OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16434)
-- Name: inventario_golosina; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventario_golosina (
    "Codigo" character varying(10) NOT NULL,
    "GolosinaCodigo" character varying(10) NOT NULL,
    "SucursarCodigo" character varying(10) NOT NULL,
    "Stock" integer NOT NULL,
    "Estado" "char" NOT NULL
);


ALTER TABLE public.inventario_golosina OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16437)
-- Name: pelicula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pelicula (
    codigo character varying(10) NOT NULL,
    nombre character varying(255) NOT NULL,
    sinopsis character varying NOT NULL,
    duracion time(5) without time zone NOT NULL,
    clasificacion character varying(255) NOT NULL,
    fecha_estreno date NOT NULL,
    genero character varying(200) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.pelicula OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16442)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    codigo character varying(10) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16445)
-- Name: sala; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sala (
    codigo character varying(10) NOT NULL,
    sucursal_codigo character varying(10) NOT NULL,
    fila integer NOT NULL,
    columna integer NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.sala OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16448)
-- Name: sucursal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sucursal (
    codigo character varying(10) NOT NULL,
    empresa_codigo character varying(25) NOT NULL,
    ciudad_codigo character varying(10) NOT NULL,
    nombre character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    telefono character varying,
    estado character(1)
);


ALTER TABLE public.sucursal OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16453)
-- Name: ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket (
    codigo character varying(10) NOT NULL,
    factura_codigo character varying(10) NOT NULL,
    tipo character varying(1) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.ticket OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16456)
-- Name: ticket_funcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket_funcion (
    "Codigo" character varying(10) NOT NULL,
    "TicketCodigo" character varying(10) NOT NULL,
    "FuncionCodigo" character varying(10) NOT NULL,
    "Butaca" character varying(100) NOT NULL,
    "Tipo" character varying(1) NOT NULL
);


ALTER TABLE public.ticket_funcion OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16459)
-- Name: ticket_golosinas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket_golosinas (
    codigo character varying(10) NOT NULL,
    inventario_gcodigo character varying(10) NOT NULL,
    ticket_codigo character varying(10) NOT NULL,
    cantidad integer NOT NULL
);


ALTER TABLE public.ticket_golosinas OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16462)
-- Name: tipo_dia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_dia (
    codigo character varying(10) NOT NULL,
    dia character varying(10) NOT NULL,
    mes character varying(10) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.tipo_dia OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16465)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    correo character varying(255) NOT NULL,
    empleado_cedula character varying(10),
    rol_codigo character varying(10),
    clave character varying(16) NOT NULL,
    estado "char" NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 4960 (class 0 OID 16399)
-- Dependencies: 215
-- Data for Name: bloque; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4961 (class 0 OID 16402)
-- Dependencies: 216
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ciudad VALUES ('CIU-03', 'Caracas', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.ciudad VALUES ('CIU-01', 'Cabudare', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.ciudad VALUES ('CIU-02', 'Barquisimeto', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4962 (class 0 OID 16405)
-- Dependencies: 217
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente VALUES ('26772857', 'Gustavo', 'Rivero', 'Cabudare', 'gustavoerivero@cines.com', 4141524152, '1997-12-12', 'R', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4963 (class 0 OID 16410)
-- Dependencies: 218
-- Data for Name: empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.empleado VALUES ('V00000000', 'SUC-01', 'Admin', 'Sistema', 4149561231, 'System', '1997-12-12', '2023-10-19', 'admin@cines.com', 'Admin', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.empleado VALUES ('V11111111', 'SUC-01', 'Esteban', 'Dido', 4145246321, 'Cabudare', '2000-02-23', '2023-10-19', 'esteban@cines.com', 'Vendedor de golosinas', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.empleado VALUES ('V22222222', 'SUC-01', 'Ana', 'Tomía', 4125412541, 'Cabudare', '1998-03-16', '2023-10-19', 'ana@cines.com', 'Vendedor de boletos', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.empleado VALUES ('V33333333', 'SUC-01', 'Gustavo', 'Rivero', 4147854123, 'Cabudare', '1997-12-12', '2023-10-19', 'gustavoerivero12@gmail.com', 'Administrador', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4964 (class 0 OID 16415)
-- Dependencies: 219
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.empresa VALUES ('J-12345678-9', 'Cines de Venezuela', 'Red de cadena de cines por toda Venezuela.', 'cinesdv@gmail.com', 5, 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4965 (class 0 OID 16420)
-- Dependencies: 220
-- Data for Name: factura; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4966 (class 0 OID 16423)
-- Dependencies: 221
-- Data for Name: funcion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4967 (class 0 OID 16428)
-- Dependencies: 222
-- Data for Name: golosinas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.golosinas VALUES ('GOL-01', 'Flips Dulce de Leche', 'Flips de dulce de leche', 3.12, 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.golosinas VALUES ('GOL-02', 'Trululu Clásico', 'Unos trululu clásicos', 1.5, 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4968 (class 0 OID 16431)
-- Dependencies: 223
-- Data for Name: horario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4969 (class 0 OID 16434)
-- Dependencies: 224
-- Data for Name: inventario_golosina; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.inventario_golosina VALUES ('INV-01', 'GOL-01', 'SUC-01', 250, 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.inventario_golosina VALUES ('INV-02', 'GOL-02', 'SUC-01', 10, 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.inventario_golosina VALUES ('INV-03', 'GOL-01', 'SUC-02', 125, 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4970 (class 0 OID 16437)
-- Dependencies: 225
-- Data for Name: pelicula; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4971 (class 0 OID 16442)
-- Dependencies: 226
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.rol VALUES ('ROL-01', 'Administrador', 'Administrador del sistema', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.rol VALUES ('ROL-02', 'Gerente', 'Gerente del Cine', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.rol VALUES ('ROL-03', 'Vendedor de boletos', 'Vendedor de tickets para función', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.rol VALUES ('ROL-04', 'Vendedor de golosinas', 'Vendedor de tickets para golosinas', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4972 (class 0 OID 16445)
-- Dependencies: 227
-- Data for Name: sala; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4973 (class 0 OID 16448)
-- Dependencies: 228
-- Data for Name: sucursal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sucursal VALUES ('SUC-01', 'J-12345678-9', 'CIU-01', 'Cine de Ciudad Comercial Traki, Cabudare', 'Cabudare por Intercomunal Acarigua-Barquisimeto', '02514523621', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.sucursal VALUES ('SUC-02', 'J-12345678-9', 'CIU-02', 'Cine de Sambil, Barquisimeto', 'Sambil de Barquisimeto', '02514512514', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4974 (class 0 OID 16453)
-- Dependencies: 229
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4975 (class 0 OID 16456)
-- Dependencies: 230
-- Data for Name: ticket_funcion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4976 (class 0 OID 16459)
-- Dependencies: 231
-- Data for Name: ticket_golosinas; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4977 (class 0 OID 16462)
-- Dependencies: 232
-- Data for Name: tipo_dia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4978 (class 0 OID 16465)
-- Dependencies: 233
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario VALUES ('admin@cines.com', 'V00000000', 'ROL-01', 'Tavo9712*', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.usuario VALUES ('esteban@cines.com', 'V11111111', 'ROL-04', '12345678', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.usuario VALUES ('ana@cines.com', 'V22222222', 'ROL-03', '12345678', 'A') ON CONFLICT DO NOTHING;
INSERT INTO public.usuario VALUES ('gustavoerivero12@gmail.com', 'V33333333', 'ROL-01', '12345678', 'A') ON CONFLICT DO NOTHING;


--
-- TOC entry 4762 (class 2606 OID 16469)
-- Name: ciudad Ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT "Ciudad_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4764 (class 2606 OID 16471)
-- Name: cliente Cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT "Cliente_pkey" PRIMARY KEY (cedula);


--
-- TOC entry 4794 (class 2606 OID 16473)
-- Name: tipo_dia Dia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_dia
    ADD CONSTRAINT "Dia_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4766 (class 2606 OID 16475)
-- Name: empleado Empleado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT "Empleado_pkey" PRIMARY KEY (cedula);


--
-- TOC entry 4768 (class 2606 OID 16477)
-- Name: empresa Empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT "Empresa_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4770 (class 2606 OID 16479)
-- Name: factura Factura_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "Factura_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4772 (class 2606 OID 16481)
-- Name: funcion Funcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "Funcion_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4774 (class 2606 OID 16483)
-- Name: golosinas Golosinas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.golosinas
    ADD CONSTRAINT "Golosinas_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4760 (class 2606 OID 16485)
-- Name: bloque Hora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bloque
    ADD CONSTRAINT "Hora_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4776 (class 2606 OID 16487)
-- Name: horario Horario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "Horario_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4778 (class 2606 OID 16489)
-- Name: inventario_golosina InventarioGolosina_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "InventarioGolosina_pkey" PRIMARY KEY ("Codigo");


--
-- TOC entry 4780 (class 2606 OID 16491)
-- Name: pelicula Pelicula_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT "Pelicula_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4782 (class 2606 OID 16493)
-- Name: rol Rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4784 (class 2606 OID 16495)
-- Name: sala Sala_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala
    ADD CONSTRAINT "Sala_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4790 (class 2606 OID 16497)
-- Name: ticket_funcion TicketFuncion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "TicketFuncion_pkey" PRIMARY KEY ("Codigo");


--
-- TOC entry 4792 (class 2606 OID 16499)
-- Name: ticket_golosinas TicketGolosinas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "TicketGolosinas_pkey" PRIMARY KEY (codigo);


--
-- TOC entry 4786 (class 2606 OID 16501)
-- Name: sucursal sucursal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT sucursal_pkey PRIMARY KEY (codigo);


--
-- TOC entry 4788 (class 2606 OID 16550)
-- Name: ticket ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (codigo);


--
-- TOC entry 4796 (class 2606 OID 16518)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (correo);


--
-- TOC entry 4802 (class 2606 OID 16571)
-- Name: horario Bloque; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "Bloque" FOREIGN KEY (bloque_codigo) REFERENCES public.bloque(codigo) NOT VALID;


--
-- TOC entry 4808 (class 2606 OID 16507)
-- Name: sucursal Ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT "Ciudad" FOREIGN KEY (ciudad_codigo) REFERENCES public.ciudad(codigo) NOT VALID;


--
-- TOC entry 4798 (class 2606 OID 16534)
-- Name: factura Cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "Cliente" FOREIGN KEY (cliente_cedula) REFERENCES public.cliente(cedula) NOT VALID;


--
-- TOC entry 4815 (class 2606 OID 16519)
-- Name: usuario Empleado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Empleado" FOREIGN KEY (empleado_cedula) REFERENCES public.empleado(cedula) NOT VALID;


--
-- TOC entry 4799 (class 2606 OID 16529)
-- Name: factura Empleado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.factura
    ADD CONSTRAINT "Empleado" FOREIGN KEY (empleado_cedula) REFERENCES public.empleado(cedula) NOT VALID;


--
-- TOC entry 4809 (class 2606 OID 16502)
-- Name: sucursal Empresa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sucursal
    ADD CONSTRAINT "Empresa" FOREIGN KEY (empresa_codigo) REFERENCES public.empresa(codigo) NOT VALID;


--
-- TOC entry 4810 (class 2606 OID 16551)
-- Name: ticket Factura; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT "Factura" FOREIGN KEY (factura_codigo) REFERENCES public.factura(codigo) NOT VALID;


--
-- TOC entry 4811 (class 2606 OID 16601)
-- Name: ticket_funcion Funcion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "Funcion" FOREIGN KEY ("FuncionCodigo") REFERENCES public.funcion(codigo) NOT VALID;


--
-- TOC entry 4805 (class 2606 OID 16539)
-- Name: inventario_golosina Golosina; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "Golosina" FOREIGN KEY ("GolosinaCodigo") REFERENCES public.golosinas(codigo) NOT VALID;


--
-- TOC entry 4800 (class 2606 OID 16586)
-- Name: funcion Horario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "Horario" FOREIGN KEY (horario_codigo) REFERENCES public.horario(codigo) NOT VALID;


--
-- TOC entry 4813 (class 2606 OID 16561)
-- Name: ticket_golosinas InventarioGolosina; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "InventarioGolosina" FOREIGN KEY (inventario_gcodigo) REFERENCES public.inventario_golosina("Codigo") NOT VALID;


--
-- TOC entry 4801 (class 2606 OID 16581)
-- Name: funcion Pelicula; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcion
    ADD CONSTRAINT "Pelicula" FOREIGN KEY (pelicula_codigo) REFERENCES public.pelicula(codigo) NOT VALID;


--
-- TOC entry 4816 (class 2606 OID 16524)
-- Name: usuario Rol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Rol" FOREIGN KEY (rol_codigo) REFERENCES public.rol(codigo) NOT VALID;


--
-- TOC entry 4803 (class 2606 OID 16591)
-- Name: horario Sala; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "Sala" FOREIGN KEY (sala_codigo) REFERENCES public.sala(codigo) NOT VALID;


--
-- TOC entry 4797 (class 2606 OID 16512)
-- Name: empleado Sucursal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT "Sucursal" FOREIGN KEY (sucursal_codigo) REFERENCES public.sucursal(codigo) NOT VALID;


--
-- TOC entry 4806 (class 2606 OID 16544)
-- Name: inventario_golosina Sucursal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario_golosina
    ADD CONSTRAINT "Sucursal" FOREIGN KEY ("SucursarCodigo") REFERENCES public.sucursal(codigo) NOT VALID;


--
-- TOC entry 4807 (class 2606 OID 16566)
-- Name: sala Sucursal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala
    ADD CONSTRAINT "Sucursal" FOREIGN KEY (sucursal_codigo) REFERENCES public.sucursal(codigo) NOT VALID;


--
-- TOC entry 4814 (class 2606 OID 16556)
-- Name: ticket_golosinas Ticket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_golosinas
    ADD CONSTRAINT "Ticket" FOREIGN KEY (ticket_codigo) REFERENCES public.ticket(codigo) NOT VALID;


--
-- TOC entry 4812 (class 2606 OID 16596)
-- Name: ticket_funcion Ticket; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket_funcion
    ADD CONSTRAINT "Ticket" FOREIGN KEY ("TicketCodigo") REFERENCES public.ticket(codigo) NOT VALID;


--
-- TOC entry 4804 (class 2606 OID 16576)
-- Name: horario TipoDia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horario
    ADD CONSTRAINT "TipoDia" FOREIGN KEY (tipo_dia_codigo) REFERENCES public.tipo_dia(codigo) NOT VALID;


-- Completed on 2023-10-21 08:42:24

--
-- PostgreSQL database dump complete
--

