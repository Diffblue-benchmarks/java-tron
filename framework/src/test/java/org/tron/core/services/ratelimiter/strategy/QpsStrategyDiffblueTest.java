package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class QpsStrategyDiffblueTest {
  /**
   * Method under test: {@link QpsStrategy#defaultParam()}
   */
  @Test
  public void testDefaultParam() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualDefaultParamResult = (new QpsStrategy("qps=42")).defaultParam();

    // Assert
    assertEquals(1, actualDefaultParamResult.size());
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, actualDefaultParamResult.get(QpsStrategy.STRATEGY_PARAM_QPS).type);
  }

  /**
   * Method under test: {@link QpsStrategy#acquire()}
   */
  @Test
  public void testAcquire() {
    // Arrange, Act and Assert
    assertTrue((new QpsStrategy("qps=42")).acquire());
  }

  /**
   * Method under test: {@link QpsStrategy#QpsStrategy(String)}
   */
  @Test
  public void testNewQpsStrategy() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new QpsStrategy("qps=42")).getMapParams();
    assertEquals(1, mapParams.size());
    Strategy.ParamItem getResult = mapParams.get(QpsStrategy.STRATEGY_PARAM_QPS);
    assertEquals(42.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }
}
