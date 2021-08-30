package by.part10.chain;

public class Main {

  private static AuthenticationProcessor getChainOfAuthProcessor() {
    AuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
    return new UsernamePasswordProcessor(oAuthProcessor);
  }

  public static void main(String[] args) {

    AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();

    System.out.println(authProcessorChain.isAuthorized(new OAuthTokenProvider())); //true

    System.out.println(authProcessorChain.isAuthorized(new SamlAuthenticationProvider())); // false
  }
}
