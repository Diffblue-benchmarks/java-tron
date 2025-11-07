package org.tron.core.metrics.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class NetInfoDiffblueTest {
  /**
   * Test {@link NetInfo#equals(Object)}, and {@link NetInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NetInfo#equals(Object)}
   *   <li>{@link NetInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NetInfo.equals(Object)", "int NetInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo2 = new NetInfo();
    netInfo2.setApi(api2);
    netInfo2.setConnectionCount(3);
    netInfo2.setDisconnectionCount(3);
    netInfo2.setDisconnectionDetail(new ArrayList<>());
    netInfo2.setLatency(latency2);
    netInfo2.setTcpInTraffic(new RateInfo());
    netInfo2.setTcpOutTraffic(new RateInfo());
    netInfo2.setUdpInTraffic(new RateInfo());
    netInfo2.setUdpOutTraffic(new RateInfo());
    netInfo2.setValidConnectionCount(1);

    // Act and Assert
    assertEquals(netInfo, netInfo2);
    int expectedHashCodeResult = netInfo.hashCode();
    assertEquals(expectedHashCodeResult, netInfo2.hashCode());
  }

  /**
   * Test {@link NetInfo#equals(Object)}, and {@link NetInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NetInfo#equals(Object)}
   *   <li>{@link NetInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NetInfo.equals(Object)", "int NetInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    // Act and Assert
    assertEquals(netInfo, netInfo);
    int expectedHashCodeResult = netInfo.hashCode();
    assertEquals(expectedHashCodeResult, netInfo.hashCode());
  }

  /**
   * Test {@link NetInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NetInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NetInfo.equals(Object)", "int NetInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiInfo api = mock(ApiInfo.class);
    doNothing().when(api).setDetail(Mockito.<List<ApiDetailInfo>>any());
    doNothing().when(api).setFailQps(Mockito.<RateInfo>any());
    doNothing().when(api).setOutTraffic(Mockito.<RateInfo>any());
    doNothing().when(api).setQps(Mockito.<RateInfo>any());
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    ApiInfo api2 = new ApiInfo();
    api2.setDetail(new ArrayList<>());
    api2.setFailQps(new RateInfo());
    api2.setOutTraffic(new RateInfo());
    api2.setQps(new RateInfo());

    LatencyInfo latency2 = new LatencyInfo();
    latency2.setDelay1S(1);
    latency2.setDelay2S(1);
    latency2.setDelay3S(1);
    latency2.setDetail(new ArrayList<>());
    latency2.setTop75(1);
    latency2.setTop95(1);
    latency2.setTop99(1);
    latency2.setTotalCount(3);

    NetInfo netInfo2 = new NetInfo();
    netInfo2.setApi(api2);
    netInfo2.setConnectionCount(3);
    netInfo2.setDisconnectionCount(3);
    netInfo2.setDisconnectionDetail(new ArrayList<>());
    netInfo2.setLatency(latency2);
    netInfo2.setTcpInTraffic(new RateInfo());
    netInfo2.setTcpOutTraffic(new RateInfo());
    netInfo2.setUdpInTraffic(new RateInfo());
    netInfo2.setUdpOutTraffic(new RateInfo());
    netInfo2.setValidConnectionCount(1);

    // Act and Assert
    assertNotEquals(netInfo, netInfo2);
  }

  /**
   * Test {@link NetInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NetInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NetInfo.equals(Object)", "int NetInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    // Act and Assert
    assertNotEquals(netInfo, null);
  }

  /**
   * Test {@link NetInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NetInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NetInfo.equals(Object)", "int NetInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());

    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);

    NetInfo netInfo = new NetInfo();
    netInfo.setApi(api);
    netInfo.setConnectionCount(3);
    netInfo.setDisconnectionCount(3);
    netInfo.setDisconnectionDetail(new ArrayList<>());
    netInfo.setLatency(latency);
    netInfo.setTcpInTraffic(new RateInfo());
    netInfo.setTcpOutTraffic(new RateInfo());
    netInfo.setUdpInTraffic(new RateInfo());
    netInfo.setUdpOutTraffic(new RateInfo());
    netInfo.setValidConnectionCount(1);

    // Act and Assert
    assertNotEquals(netInfo, "Different type to NetInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NetInfo}
   *   <li>{@link NetInfo#setApi(ApiInfo)}
   *   <li>{@link NetInfo#setConnectionCount(int)}
   *   <li>{@link NetInfo#setDisconnectionCount(int)}
   *   <li>{@link NetInfo#setDisconnectionDetail(List)}
   *   <li>{@link NetInfo#setLatency(LatencyInfo)}
   *   <li>{@link NetInfo#setTcpInTraffic(RateInfo)}
   *   <li>{@link NetInfo#setTcpOutTraffic(RateInfo)}
   *   <li>{@link NetInfo#setUdpInTraffic(RateInfo)}
   *   <li>{@link NetInfo#setUdpOutTraffic(RateInfo)}
   *   <li>{@link NetInfo#setValidConnectionCount(int)}
   *   <li>{@link NetInfo#setErrorProtoCount(int)}
   *   <li>{@link NetInfo#toString()}
   *   <li>{@link NetInfo#getApi()}
   *   <li>{@link NetInfo#getConnectionCount()}
   *   <li>{@link NetInfo#getDisconnectionCount()}
   *   <li>{@link NetInfo#getDisconnectionDetail()}
   *   <li>{@link NetInfo#getErrorProtoCount()}
   *   <li>{@link NetInfo#getLatency()}
   *   <li>{@link NetInfo#getTcpInTraffic()}
   *   <li>{@link NetInfo#getTcpOutTraffic()}
   *   <li>{@link NetInfo#getUdpInTraffic()}
   *   <li>{@link NetInfo#getUdpOutTraffic()}
   *   <li>{@link NetInfo#getValidConnectionCount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NetInfo.<init>()", "ApiInfo NetInfo.getApi()", "int NetInfo.getConnectionCount()",
      "int NetInfo.getDisconnectionCount()", "List NetInfo.getDisconnectionDetail()",
      "int NetInfo.getErrorProtoCount()", "LatencyInfo NetInfo.getLatency()", "RateInfo NetInfo.getTcpInTraffic()",
      "RateInfo NetInfo.getTcpOutTraffic()", "RateInfo NetInfo.getUdpInTraffic()",
      "RateInfo NetInfo.getUdpOutTraffic()", "int NetInfo.getValidConnectionCount()", "void NetInfo.setApi(ApiInfo)",
      "void NetInfo.setConnectionCount(int)", "void NetInfo.setDisconnectionCount(int)",
      "void NetInfo.setDisconnectionDetail(List)", "void NetInfo.setErrorProtoCount(int)",
      "void NetInfo.setLatency(LatencyInfo)", "void NetInfo.setTcpInTraffic(RateInfo)",
      "void NetInfo.setTcpOutTraffic(RateInfo)", "void NetInfo.setUdpInTraffic(RateInfo)",
      "void NetInfo.setUdpOutTraffic(RateInfo)", "void NetInfo.setValidConnectionCount(int)",
      "String NetInfo.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    NetInfo actualNetInfo = new NetInfo();
    ApiInfo api = new ApiInfo();
    api.setDetail(new ArrayList<>());
    api.setFailQps(new RateInfo());
    api.setOutTraffic(new RateInfo());
    api.setQps(new RateInfo());
    actualNetInfo.setApi(api);
    actualNetInfo.setConnectionCount(3);
    actualNetInfo.setDisconnectionCount(3);
    ArrayList<DisconnectionDetailInfo> disconnectionDetail = new ArrayList<>();
    actualNetInfo.setDisconnectionDetail(disconnectionDetail);
    LatencyInfo latency = new LatencyInfo();
    latency.setDelay1S(1);
    latency.setDelay2S(1);
    latency.setDelay3S(1);
    latency.setDetail(new ArrayList<>());
    latency.setTop75(1);
    latency.setTop95(1);
    latency.setTop99(1);
    latency.setTotalCount(3);
    actualNetInfo.setLatency(latency);
    RateInfo tcpInTraffic = new RateInfo();
    actualNetInfo.setTcpInTraffic(tcpInTraffic);
    RateInfo tcpOutTraffic = new RateInfo();
    actualNetInfo.setTcpOutTraffic(tcpOutTraffic);
    RateInfo udpInTraffic = new RateInfo();
    actualNetInfo.setUdpInTraffic(udpInTraffic);
    RateInfo udpOutTraffic = new RateInfo();
    actualNetInfo.setUdpOutTraffic(udpOutTraffic);
    actualNetInfo.setValidConnectionCount(1);
    actualNetInfo.setErrorProtoCount(3);
    String actualToStringResult = actualNetInfo.toString();
    ApiInfo actualApi = actualNetInfo.getApi();
    int actualConnectionCount = actualNetInfo.getConnectionCount();
    int actualDisconnectionCount = actualNetInfo.getDisconnectionCount();
    List<DisconnectionDetailInfo> actualDisconnectionDetail = actualNetInfo.getDisconnectionDetail();
    int actualErrorProtoCount = actualNetInfo.getErrorProtoCount();
    LatencyInfo actualLatency = actualNetInfo.getLatency();
    RateInfo actualTcpInTraffic = actualNetInfo.getTcpInTraffic();
    RateInfo actualTcpOutTraffic = actualNetInfo.getTcpOutTraffic();
    RateInfo actualUdpInTraffic = actualNetInfo.getUdpInTraffic();
    RateInfo actualUdpOutTraffic = actualNetInfo.getUdpOutTraffic();

    // Assert
    assertEquals(
        "NetInfo(errorProtoCount=3, api=ApiInfo(qps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0,"
            + " fifteenMinuteRate=0.0, count=0), failQps=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0,"
            + " fifteenMinuteRate=0.0, count=0), outTraffic=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0,"
            + " fifteenMinuteRate=0.0, count=0), detail=[]), connectionCount=3, validConnectionCount=1, tcpInTraffic"
            + "=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0, count=0),"
            + " tcpOutTraffic=RateInfo(meanRate=0.0, oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0,"
            + " count=0), disconnectionCount=3, disconnectionDetail=[], udpInTraffic=RateInfo(meanRate=0.0,"
            + " oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0, count=0), udpOutTraffic=RateInfo(meanRate=0.0,"
            + " oneMinuteRate=0.0, fiveMinuteRate=0.0, fifteenMinuteRate=0.0, count=0), latency=LatencyInfo(top99=1,"
            + " top95=1, top75=1, totalCount=3, delay1S=1, delay2S=1, delay3S=1, detail=[]))",
        actualToStringResult);
    assertEquals(1, actualNetInfo.getValidConnectionCount());
    assertEquals(3, actualConnectionCount);
    assertEquals(3, actualDisconnectionCount);
    assertEquals(3, actualErrorProtoCount);
    assertTrue(actualDisconnectionDetail.isEmpty());
    assertSame(disconnectionDetail, actualDisconnectionDetail);
    assertSame(api, actualApi);
    assertSame(latency, actualLatency);
    assertSame(tcpInTraffic, actualTcpInTraffic);
    assertSame(tcpOutTraffic, actualTcpOutTraffic);
    assertSame(udpInTraffic, actualUdpInTraffic);
    assertSame(udpOutTraffic, actualUdpOutTraffic);
  }
}
