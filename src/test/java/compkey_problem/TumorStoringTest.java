/**
 *
 * This software is written by arcus(x) GmbH and subject 
 * to a contract between arcus(x) and its customer.
 *
 * This software stays property of arcus(x) unless differing
 * arrangements between arcus(x) and its customer apply.
 *
 * arcus(x) GmbH
 * Hamburg, Germany
 *
 * Tel.: +49 (0)40.333 102 92 
 * Fax.: +49 (0)40.333 102 93 
 * http://www.arcusx.com
 * mailto:info@arcusx.com
 *
 */

package compkey_problem;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import compkey_problem.model.FluidSample;
import compkey_problem.model.SampleGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TumorStoringTest
{
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void testStoringSample() throws Exception
	{
		SampleGroup sampleGroup = new SampleGroup();
		final FluidSample sample = sampleGroup.addNewPreFluidSample();
		sample.setAmount(BigDecimal.ONE);
		sample.addNewLabel("test");
		this.sessionFactory.getCurrentSession().persist(sampleGroup);
	}
}
