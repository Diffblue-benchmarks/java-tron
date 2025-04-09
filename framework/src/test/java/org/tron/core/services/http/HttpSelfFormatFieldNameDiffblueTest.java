package org.tron.core.services.http;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HttpSelfFormatFieldNameDiffblueTest {
  /**
   * Test {@link HttpSelfFormatFieldName#isAddressFormat(String)}.
   * <p>
   * Method under test: {@link HttpSelfFormatFieldName#isAddressFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HttpSelfFormatFieldName.isAddressFormat(String)"})
  public void testIsAddressFormat() {
    // Arrange, Act and Assert
    assertFalse(HttpSelfFormatFieldName.isAddressFormat("https://example.org/example"));
  }

  /**
   * Test {@link HttpSelfFormatFieldName#isNameStringFormat(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpSelfFormatFieldName#isNameStringFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HttpSelfFormatFieldName.isNameStringFormat(String)"})
  public void testIsNameStringFormat_whenHttpsExampleOrgExample_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(HttpSelfFormatFieldName.isNameStringFormat("https://example.org/example"));
  }

  /**
   * Test {@link HttpSelfFormatFieldName#isNameStringFormat(String)}.
   * <ul>
   *   <li>When {@code protocol.MarketPriceList.buy_token_id}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpSelfFormatFieldName#isNameStringFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HttpSelfFormatFieldName.isNameStringFormat(String)"})
  public void testIsNameStringFormat_whenProtocolMarketPriceListBuyTokenId_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(HttpSelfFormatFieldName.isNameStringFormat("protocol.MarketPriceList.buy_token_id"));
  }
}
