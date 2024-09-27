--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2024-09-27 10:21:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3341 (class 1262 OID 120883)
-- Name: telefonica; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE telefonica WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Mexico.1252';


ALTER DATABASE telefonica OWNER TO postgres;

\connect telefonica

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 120903)
-- Name: pruebacalse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pruebacalse (
    eid integer NOT NULL,
    nombre character varying NOT NULL,
    aula character varying NOT NULL,
    horario character varying NOT NULL
);


ALTER TABLE public.pruebacalse OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 120902)
-- Name: pruebacalse_eid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pruebacalse_eid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pruebacalse_eid_seq OWNER TO postgres;

--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 216
-- Name: pruebacalse_eid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pruebacalse_eid_seq OWNED BY public.pruebacalse.eid;


--
-- TOC entry 215 (class 1259 OID 120885)
-- Name: pruebaestudiante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pruebaestudiante (
    eid integer NOT NULL,
    nombre character varying NOT NULL,
    especialidad character varying NOT NULL,
    grado character varying
);


ALTER TABLE public.pruebaestudiante OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 120884)
-- Name: pruebaestudiante_eid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pruebaestudiante_eid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pruebaestudiante_eid_seq OWNER TO postgres;

--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 214
-- Name: pruebaestudiante_eid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pruebaestudiante_eid_seq OWNED BY public.pruebaestudiante.eid;


--
-- TOC entry 218 (class 1259 OID 120916)
-- Name: pruebainscripcion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pruebainscripcion (
    eid integer NOT NULL,
    nombre_clase character varying NOT NULL,
    posicion numeric NOT NULL
);


ALTER TABLE public.pruebainscripcion OWNER TO postgres;

--
-- TOC entry 3183 (class 2604 OID 120906)
-- Name: pruebacalse eid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pruebacalse ALTER COLUMN eid SET DEFAULT nextval('public.pruebacalse_eid_seq'::regclass);


--
-- TOC entry 3182 (class 2604 OID 120888)
-- Name: pruebaestudiante eid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pruebaestudiante ALTER COLUMN eid SET DEFAULT nextval('public.pruebaestudiante_eid_seq'::regclass);


--
-- TOC entry 3334 (class 0 OID 120903)
-- Dependencies: 217
-- Data for Name: pruebacalse; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pruebacalse VALUES (1, 'BA200', 'SC110', 'M-F9');
INSERT INTO public.pruebacalse VALUES (2, 'BD445', 'SC213', 'MWF3');
INSERT INTO public.pruebacalse VALUES (3, 'BF410', 'SC213', 'MWF8');
INSERT INTO public.pruebacalse VALUES (4, 'CS150', 'EA304', 'MWF3');


--
-- TOC entry 3332 (class 0 OID 120885)
-- Dependencies: 215
-- Data for Name: pruebaestudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pruebaestudiante VALUES (100, 'JONES', 'HISTORIA', 'GR');
INSERT INTO public.pruebaestudiante VALUES (150, 'PARKS', 'CONTABILIDAD', 'SO');
INSERT INTO public.pruebaestudiante VALUES (200, 'BAKER', 'MATEMATICAS', 'GR');
INSERT INTO public.pruebaestudiante VALUES (250, 'GLASS', 'HISTORIA', 'SN');
INSERT INTO public.pruebaestudiante VALUES (300, 'BAKER', 'CONTABILIDAD', 'SN');
INSERT INTO public.pruebaestudiante VALUES (350, 'RUSSELL', 'MATEMATICAS', 'JR');
INSERT INTO public.pruebaestudiante VALUES (400, 'REY', 'HISTORIA', 'FR');
INSERT INTO public.pruebaestudiante VALUES (450, 'REY', 'CONTABILIDAD', 'SN');


--
-- TOC entry 3335 (class 0 OID 120916)
-- Dependencies: 218
-- Data for Name: pruebainscripcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pruebainscripcion VALUES (100, 'BD445', 1);
INSERT INTO public.pruebainscripcion VALUES (150, 'BA200', 1);
INSERT INTO public.pruebainscripcion VALUES (200, 'BD445', 2);
INSERT INTO public.pruebainscripcion VALUES (200, 'CS250', 1);
INSERT INTO public.pruebainscripcion VALUES (300, 'CS150', 1);
INSERT INTO public.pruebainscripcion VALUES (400, 'BA200', 2);
INSERT INTO public.pruebainscripcion VALUES (400, 'BF410', 1);
INSERT INTO public.pruebainscripcion VALUES (400, 'CS250', 2);
INSERT INTO public.pruebainscripcion VALUES (450, 'BA200', 3);


--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 216
-- Name: pruebacalse_eid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pruebacalse_eid_seq', 4, true);


--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 214
-- Name: pruebaestudiante_eid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pruebaestudiante_eid_seq', 1, false);


--
-- TOC entry 3187 (class 2606 OID 120910)
-- Name: pruebacalse pruebacalse_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pruebacalse
    ADD CONSTRAINT pruebacalse_pk PRIMARY KEY (eid);


--
-- TOC entry 3185 (class 2606 OID 120892)
-- Name: pruebaestudiante pruebaestudiante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pruebaestudiante
    ADD CONSTRAINT pruebaestudiante_pk PRIMARY KEY (eid);


--
-- TOC entry 3188 (class 2606 OID 120921)
-- Name: pruebainscripcion pruebainscripcion_pruebaestudiante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pruebainscripcion
    ADD CONSTRAINT pruebainscripcion_pruebaestudiante_fk FOREIGN KEY (eid) REFERENCES public.pruebaestudiante(eid);


-- Completed on 2024-09-27 10:21:20

--
-- PostgreSQL database dump complete
--

