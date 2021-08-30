package by.part5.e5backpressure;

public interface RefCounted {

  long refCount();

  void release();
}