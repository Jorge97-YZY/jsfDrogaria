package com.jorge.drogaria;


import org.hibernate.Session;
import org.junit.Test;

import com.jorge.drogaria.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
		
	}
}
