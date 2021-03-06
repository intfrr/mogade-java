package com.mogade.java.tests.unit;

import com.mogade.java.MogadeConfiguration;
import com.mogade.java.MogadeConfigurationImpl;
import com.mogade.java.MogadeException;
import org.junit.Test;
import static junit.framework.Assert.*;

public class TestMogadeConfiguration
{
   @Test(expected = MogadeException.class)
   public void testSetApiUrlInvalid()
   {
      MogadeConfigurationImpl.instance().setApiUrl(null);
   }
   @Test(expected = MogadeException.class)
   public void testSetApiUrlInvalid2()
   {
      MogadeConfigurationImpl.instance().setApiUrl("");
   }
   @Test
   public void testGetSetApiUrl()
   {
      assertNotNull(MogadeConfigurationImpl.instance().getApiUrl());
      MogadeConfigurationImpl.instance().setApiUrl("brian");
      assertEquals("brian", MogadeConfigurationImpl.instance().getApiUrl());
   }
   @Test(expected = MogadeException.class)
   public void testSetConnectTimeoutInvalid()
   {
      MogadeConfigurationImpl.instance().setConnectTimeout(-1);
   }
   @Test
   public void testGetSetConnectTimeout()
   {
      assertTrue(MogadeConfigurationImpl.instance().getConnectTimeout() > 0);
      MogadeConfigurationImpl.instance().setConnectTimeout(2);
      assertEquals(2, MogadeConfigurationImpl.instance().getConnectTimeout());
   }
   @Test(expected = MogadeException.class)
   public void testSetReadTimeoutInvalid()
   {
      MogadeConfigurationImpl.instance().setReadTimeout(-1);
   }
   @Test
   public void testGetSetReadTimeout()
   {
      assertTrue(MogadeConfigurationImpl.instance().getReadTimeout() > 0);
      MogadeConfigurationImpl.instance().setReadTimeout(2);
      assertEquals(2, MogadeConfigurationImpl.instance().getReadTimeout());
   }
   @Test
   public void testGetSetKeepAlive()
   {
      boolean ka = MogadeConfigurationImpl.instance().getKeepAlive();
      MogadeConfigurationImpl.instance().setKeepAlive(!ka);
      assertEquals(!ka, MogadeConfigurationImpl.instance().getKeepAlive());
   }
   
   @Test
   public void testResetDefaults()
   {
      MogadeConfiguration config = MogadeConfigurationImpl.instance();
      config.setApiUrl("brian");
      config.setConnectTimeout(3);
      config.setReadTimeout(4);
      config.setKeepAlive(true);
      config.resetDefaults();

      assertFalse("brian".equals(config.getApiUrl()));
      assertFalse(3 == config.getConnectTimeout());
      assertFalse(4 == config.getReadTimeout());
      assertFalse(true == config.getKeepAlive());
   }
}