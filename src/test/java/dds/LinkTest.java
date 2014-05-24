package dds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class LinkTest {

  private Link link;
  private Dispositivo dispositivo;

  @Before
  public void setUp() {
    link = new Link();
  }

  @Test
  public void test1() {
    Dispositivo android = new Android();
    Assert.assertEquals(link.click(android), "Dispositivo desconocido");
  }

  @Test
  public void test2() {
    Android android = new Android();
    Assert.assertEquals(link.click(android), "Android");
  }

  @Test
  public void test3() {
    dispositivo = new IPad();
    Assert.assertEquals(link.click(dispositivo), "Dispositivo desconocido");
  }

  @Test
  public void test4() {
    Collection<Dispositivo> dispositivos = new ArrayList<>();
    dispositivos.add(new Android());
    dispositivos.add(new IPad());

    List<String> nombres = dispositivos
      .stream()
      .map(dispositivo -> link.click(dispositivo))
      .collect(Collectors.toList());

    assertEquals(nombres, Arrays.asList("Dispositivo desconocido", "Dispositivo desconocido"));
  }
}
