package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.strategy.Strategy.ParamItem;

public class IPQpsStrategyDiffblueTest {
  /**
   * Test {@link IPQpsStrategy#IPQpsStrategy(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IPQpsStrategy.<init>(String)"})
  public void testNewIPQpsStrategy_whenEmptyString() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new IPQpsStrategy("")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link IPQpsStrategy#IPQpsStrategy(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IPQpsStrategy.<init>(String)"})
  public void testNewIPQpsStrategy_whenNull() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new IPQpsStrategy(null)).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link IPQpsStrategy#IPQpsStrategy(String)}.
   * <ul>
   *   <li>When {@code Param String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IPQpsStrategy.<init>(String)"})
  public void testNewIPQpsStrategy_whenParamString() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new IPQpsStrategy("Param String")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link IPQpsStrategy#IPQpsStrategy(String)}.
   * <ul>
   *   <li>When {@code UUU=UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQpsStrategy#IPQpsStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IPQpsStrategy.<init>(String)"})
  public void testNewIPQpsStrategy_whenUuuUuu() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new IPQpsStrategy("UUU=UUU")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link IPQpsStrategy#acquire(String)}.
   * <ul>
   *   <li>When {@code 127.0.0.1}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IPQpsStrategy#acquire(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IPQpsStrategy.acquire(String)"})
  public void testAcquire_when127001_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new IPQpsStrategy("Param String")).acquire("127.0.0.1"));
  }

  /**
   * Test {@link IPQpsStrategy#defaultParam()}.
   * <p>
   * Method under test: {@link IPQpsStrategy#defaultParam()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map IPQpsStrategy.defaultParam()"})
  public void testDefaultParam() {
    // Arrange and Act
    Map<String, ParamItem> actualDefaultParamResult = (new IPQpsStrategy("Param String")).defaultParam();

    // Assert
    assertEquals(1, actualDefaultParamResult.size());
    ParamItem getResult = actualDefaultParamResult.get(IPQpsStrategy.STRATEGY_PARAM_IPQPS);
    assertEquals(2.0d, ((Double) getResult.value).doubleValue(), 0.0);
    Class<Double> expectedResultClass = Double.class;
    assertEquals(expectedResultClass, getResult.type);
  }
}
