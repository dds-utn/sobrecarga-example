package dds;

public class Link {
  public String click(Dispositivo dispositivo) {
    return "Dispositivo desconocido";
  }

  public String click(Android android) {
    return "Android";
  }

  public String click(IPad ipad) {
    return "iPad";
  }
}
