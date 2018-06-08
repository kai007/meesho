package meesho;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class MessageServiceBean {
    private Long orderId;

    private boolean smsSent;

    private boolean emailSent;

    private boolean invoiceGenerated;

    private boolean invoiceSent;

    public MessageServiceBean() {
    }

    public MessageServiceBean(Long orderId) {
        this.orderId = orderId;
        this.setSmsSent(false);
        this.setEmailSent(false);
        this.setInvoiceGenerated(false);
        this.setInvoiceSent(false);
    }


    public Long getOrderId() {
        return orderId;
    }

    public boolean isSmsSent() {
        return smsSent;
    }

    public void setSmsSent(boolean smsSent) {
        this.smsSent = smsSent;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

    public boolean isInvoiceGenerated() {
        return invoiceGenerated;
    }

    public void setInvoiceGenerated(boolean invoiceGenerated) {
        this.invoiceGenerated = invoiceGenerated;
    }

    public boolean isInvoiceSent() {
        return invoiceSent;
    }

    public void setInvoiceSent(boolean invoiceSent) {
        this.invoiceSent = invoiceSent;
    }
}