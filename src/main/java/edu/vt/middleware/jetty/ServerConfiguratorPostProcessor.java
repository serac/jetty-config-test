package edu.vt.middleware.jetty;

import java.util.Collection;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.LifeCycle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Marvin S. Addison
 */
public class ServerConfiguratorPostProcessor implements BeanPostProcessor
{

  private Collection<LifeCycle.Listener> lifeCycleListeners;

  public void setLifeCycleListeners(final Collection<LifeCycle.Listener> listeners)
  {
    this.lifeCycleListeners = listeners;
  }

  @Override
  public Object postProcessBeforeInitialization(final Object o, final String s) throws BeansException
  {
    return o;
  }

  @Override
  public Object postProcessAfterInitialization(final Object o, final String s) throws BeansException
  {
    if (o instanceof Server) {
      for (LifeCycle.Listener listener : lifeCycleListeners) {
        ((Server) o).addLifeCycleListener(listener);
      }
    }
    return o;
  }
}
