--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.log (
    id bigint NOT NULL,
    answer_result boolean,
    date character varying(255),
    question_id bigint,
    result character varying(255),
    student_id bigint
);


ALTER TABLE public.log OWNER TO postgres;

--
-- Name: log_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.log_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.log_sequence OWNER TO postgres;

--
-- Name: options; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.options (
    id bigint NOT NULL,
    option1 character varying(255),
    option2 character varying(255),
    option3 character varying(255),
    option4 character varying(255)
);


ALTER TABLE public.options OWNER TO postgres;

--
-- Name: options_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.options_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.options_sequence OWNER TO postgres;

--
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id bigint NOT NULL,
    dob date,
    email character varying(255),
    name character varying(255)
);


ALTER TABLE public.student OWNER TO postgres;

--
-- Name: student_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_sequence OWNER TO postgres;

--
-- Name: trivia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trivia (
    id bigint NOT NULL,
    answer character varying(255),
    category character varying(255),
    question character varying(255),
    topic character varying(255),
    fk_options_id bigint
);


ALTER TABLE public.trivia OWNER TO postgres;

--
-- Name: trivia_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trivia_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trivia_sequence OWNER TO postgres;

--
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.log (id, answer_result, date, question_id, result, student_id) FROM stdin;
1	f	2022-09-29	1	2. Federer	1
\.


--
-- Data for Name: options; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.options (id, option1, option2, option3, option4) FROM stdin;
1	1. Djokovic	2. Federer	3. Nadal	4. Sampras
2	1. Venus Williams	2. Serena Williams	3. Steffi Graf	4. Chris Evert
3	1. Chang	2. Alcaraz	3. Nadal	4. Becker
4	1. Sharapova	2. Williams	3. Raducanu	4. Hingis
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (id, dob, email, name) FROM stdin;
1	2000-01-05	mariam.jamal@gmail.com	Mariam
2	2004-01-05	alex.jamal@gmail.com	Alex
\.


--
-- Data for Name: trivia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.trivia (id, answer, category, question, topic, fk_options_id) FROM stdin;
1	3	Sport	Who has won the most men's grand slam titles in the open era?	Tennis	\N
2	2	Sport	Who has won the most woman's grand slam titles in the open era?	Tennis	\N
3	1	Sport	The youngest mens grand slam winner in the open era?	Tennis	\N
4	4	Sport	The youngest woman's grand slam winner in the open era?	Tennis	\N
\.


--
-- Name: log_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.log_sequence', 1, true);


--
-- Name: options_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.options_sequence', 4, true);


--
-- Name: student_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_sequence', 2, true);


--
-- Name: trivia_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trivia_sequence', 4, true);


--
-- Name: log log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log
    ADD CONSTRAINT log_pkey PRIMARY KEY (id);


--
-- Name: options options_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.options
    ADD CONSTRAINT options_pkey PRIMARY KEY (id);


--
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- Name: trivia trivia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trivia
    ADD CONSTRAINT trivia_pkey PRIMARY KEY (id);


--
-- Name: trivia fkqauhxlj508ja9t4j3qrhpo83d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trivia
    ADD CONSTRAINT fkqauhxlj508ja9t4j3qrhpo83d FOREIGN KEY (fk_options_id) REFERENCES public.options(id);


--
-- PostgreSQL database dump complete
--

