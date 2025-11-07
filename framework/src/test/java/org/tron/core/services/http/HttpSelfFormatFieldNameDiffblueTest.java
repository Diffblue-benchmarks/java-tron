package org.tron.core.services.http;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class HttpSelfFormatFieldNameDiffblueTest {
  /**
   * Method under test: {@link HttpSelfFormatFieldName#isAddressFormat(String)}
   */
  @Test
  public void testIsAddressFormat() {
    // Arrange, Act and Assert
    assertFalse(HttpSelfFormatFieldName.isAddressFormat("https://example.org/example"));
  }

  /**
   * Method under test: {@link HttpSelfFormatFieldName#isNameStringFormat(String)}
   */
  @Test
  public void testIsNameStringFormat() {
    // Arrange, Act and Assert
    assertFalse(HttpSelfFormatFieldName.isNameStringFormat("https://example.org/example"));
    assertTrue(HttpSelfFormatFieldName.isNameStringFormat("protocol.MarketPriceList.buy_token_id"));
  }
}
