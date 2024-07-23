package Behavioral.chainofresponsibility;

abstract class RequestHandler {
    public RequestHandler nextHandler;

    public void setNextHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
class TechnicalSupportHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Technical")) {
            System.out.println("Handling technical support request: " + request.getDescription());
        } else {
            super.handleRequest(request);
        }
    }
}

class BillingSupportHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Billing")) {
            System.out.println("Handling billing support request: " + request.getDescription());
        } else {
            super.handleRequest(request);
        }
    }
}

class GeneralSupportHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("General")) {
            System.out.println("Handling general support request: " + request.getDescription());
        } else {
            super.handleRequest(request);
        }
    }
}

class Request {
    private String type;
    private String description;

    public Request(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}


public class main {
    public static void main(String[] args) {
        RequestHandler technicalHandler = new TechnicalSupportHandler();
        RequestHandler billingHandler = new BillingSupportHandler();
        RequestHandler generalHandler = new GeneralSupportHandler();

        technicalHandler.setNextHandler(billingHandler);
        billingHandler.setNextHandler(generalHandler);

        Request techRequest = new Request("Technical", "Tech issue with the product.");
        Request billingRequest = new Request("Billing", "Billing discrepancy in the last invoice.");
        Request generalRequest = new Request("General", "General inquiry about the service.");

        technicalHandler.handleRequest(techRequest);
        technicalHandler.handleRequest(billingRequest);
        technicalHandler.handleRequest(generalRequest);
    }
}