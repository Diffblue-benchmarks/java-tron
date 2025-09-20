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
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HttpSelfFormatFieldName#isAddressFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HttpSelfFormatFieldName.isAddressFormat(String)"})
  public void testIsAddressFormat_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(HttpSelfFormatFieldName.isAddressFormat("Name"));
  }

  /**
   * Test {@link HttpSelfFormatFieldName#isNameStringFormat(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HttpSelfFormatFieldName#isNameStringFormat(String)}
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
   *
   * <ul>
   *   <li>When {@code protocol.MarketPriceList.buy_token_id}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HttpSelfFormatFieldName#isNameStringFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean HttpSelfFormatFieldName.isNameStringFormat(String)"})
  public void testIsNameStringFormat_whenProtocolMarketPriceListBuyTokenId_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(HttpSelfFormatFieldName.isNameStringFormat("protocol.MarketPriceList.buy_token_id"));
  }
}
