package edu.vt.middleware.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.LifeCycle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Marvin S. Addison
 */
@ContextConfiguration("/configuration-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WiringTest
{
  @Autowired
  private ApplicationContext context;

  @Test
  public void testSpringWiring() {
    assertNotNull(context.getBean("jetty", Server.class));
  }
}
