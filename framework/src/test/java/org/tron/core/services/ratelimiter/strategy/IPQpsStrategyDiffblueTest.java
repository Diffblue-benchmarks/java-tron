package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class IPQpsStrategyDiffblueTest {
  /**
   * Method under test: {@link IPQpsStrategy#acquire(String)}
   */
  @Test
  public void testAcquire() {
    // Arrange, Act and Assert
    assertTrue((new IPQpsStrategy("Param String")).acquire("127.0.0.1"));
  }

  /**
   * Method under test: {@link IPQpsStrategy#defaultParam()}
   */
  @Test
  public void testDefaultParam() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualDefaultParamResult = (new IPQpsStrategy("Param String")).defaultParam();

    // Assert
    assertEquals(1, actualDefaultParamResult.size());
    Strategy.ParamItem getResult = actualDefaultParamResult.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  public void testNewIPQpsStrategy() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new IPQpsStrategy("Param String")).getMapParams();
    assertEquals(1, mapParams.size());
    Strategy.ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  public void testNewIPQpsStrategy2() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new IPQpsStrategy(null)).getMapParams();
    assertEquals(1, mapParams.size());
    Strategy.ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  public void testNewIPQpsStrategy3() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new IPQpsStrategy("UUU=UUU")).getMapParams();
    assertEquals(1, mapParams.size());
    Strategy.ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  public void testNewIPQpsStrategy4() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new IPQpsStrategy("")).getMapParams();
    assertEquals(1, mapParams.size());
    Strategy.ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }
}
