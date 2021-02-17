package mnj.mfg.view.backing_bean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

public class Main {
    private RichTable lineTable;
    private RichInputComboboxListOfValues bpoNo;
    private RichInputText quantity;
    private RichInputText issuedQuantity;
    private RichInputText cutQty;
    private RichInputText belancQty;
    private RichTable cutDetail;
    private RichTable selectAllTable;
    private RichInputListOfValues rationNo;
    private RichInputComboboxListOfValues transactionTypeBind;
    private RichCommandButton fillBundleIssueButtonBinding;
    private RichCommandButton fillBundleReceiveButtonBinding;
    private RichCommandButton fillBundleThirdPartyButtonBinding;
    private RichInputComboboxListOfValues styleBind;
    private RichInputText season;
    private RichInputText buyerId;
    private RichPopup selectAllTableValues;
    private RichTable selectAllValuesTable;

    public Main() {
    }

    public void editPopupFetchListener(PopupFetchEvent popupFetchEvent) {
        // Add event code here...setPopUpWhereClause

        OperationBinding operationBinding =
            executeOperation("setPopUpWhereClause");
        operationBinding.execute();
    }

    public void editPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
        // Add event code here...
    }

    public void editDialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding =
                executeOperation("populateBundles");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineTable);
        }

    }


    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Generic Method to execute operation
     * */
    public OperationBinding executeOperation(String operation) {
        OperationBinding createParam =
            getBindingsCont().getOperationBinding(operation);
        return createParam;

    }

    public void setLineTable(RichTable lineTable) {
        this.lineTable = lineTable;
    }

    public RichTable getLineTable() {
        return lineTable;
    }

    public void setBpoNo(RichInputComboboxListOfValues bpoNo) {
        this.bpoNo = bpoNo;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("bpoNo", bpoNo.getValue());
        System.out.println("Session bpoNo-->" + bpoNo.getValue());
    }

    public RichInputComboboxListOfValues getBpoNo() {
        return bpoNo;
    }

    public void setQuantity(RichInputText quantity) {
        this.quantity = quantity;
    }

    public RichInputText getQuantity() {
        return quantity;
    }

    public void setIssuedQuantity(RichInputText issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public RichInputText getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setCutQty(RichInputText cutQty) {
        this.cutQty = cutQty;
    }

    public RichInputText getCutQty() {
        return cutQty;
    }

    public void setBelancQty(RichInputText belancQty) {
        this.belancQty = belancQty;
    }

    public RichInputText getBelancQty() {
        return belancQty;
    }

    public void valueChanger(ValueChangeEvent valueChangeEvent) {
        System.out.println("enter value change event --->");

        double Quantity =
            Double.parseDouble((getQuantity().getValue().toString()));
        double CutQty =
            Double.parseDouble((getCutQty().getValue().toString()));
        //double IssuedQuantity = Double.parseDouble((getIssuedQuantity().getValue().toString()));
        //  double belancQty = Double.parseDouble((getBelancQty().getValue().toString()));

        double tt = 0.0, gg = 0.0, ee = 0.0, hh = 0.0, MWM = 0.0;
        double val = 0.00;
        try {
            val =
Double.parseDouble(valueChangeEvent.getNewValue().toString());

        } catch (Exception e) {
            ;
        }

        double t = getCutQtySum(val);
        System.out.println("T Value in method action CutQtySum----------->" +
                           t);
        // setLineOutput(t);
        tt = (Quantity - t);
        //gg = (Quantity - IssuedQuantity);
        try {
            //issuedQuantity.setValue(tt);
            issuedQuantity.setValue(new oracle.jbo.domain.Number(tt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(issuedQuantity);
        } catch (Exception e) {

            // TODO: Add catch code
        }

        //    gg = (Quantity - IssuedQuantity);
        //    try {
        //        belancQty.setValue(gg);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(belancQty);
        //    } catch (Exception e) {
        //
        //        // TODO: Add catch code
        //    }
        System.out.println("issuedqty --->" + tt);
    }


    //    public void prodQtyAction(ValueChangeEvent valueChangeEvent) {
    //
    //        double val = 0.00;
    //        try {
    //            val =Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //
    //        } catch (Exception e) {
    //            ;
    //        }
    //
    //        double t = getCutQtySum(val);
    //        System.out.println("T Value in method action ----------->"+t);
    //        setLineOutput(t);
    //    }
    //    public void setLineOutput(double value) {
    //
    //        oracle.adf.view.rich.component.UIXTable table = getCutDetail();
    //        // Get the Selected Row key set iterator
    //        java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
    //        double cutQty = 0.0;
    //        while (selectionIt.hasNext())
    //        {
    //            Object rowKey = selectionIt.next();
    //            table.setRowKey(rowKey);
    //            int index = table.getRowIndex();
    //            FacesCtrlHierNodeBinding row =
    //                (FacesCtrlHierNodeBinding)table.getRowData(index);
    //            Row selectedRow = row.getRow();
    //            try {
    //                selectedRow.setAttribute("CutQty", value);
    //            }
    //            catch (Exception e)
    //            {
    //                ;
    //            }
    //        }
    //
    //    }

    public double getCutQtySum(double currentVal) {

        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContext.findDataControl("AppModuleDataControl");
        ApplicationModule am = dc.getApplicationModule();
        ViewObject layPlanViewObject = am.findViewObject("LineVO1");

        System.out.println("Vo name -->" + layPlanViewObject);
        RowSetIterator it = layPlanViewObject.createRowSetIterator("tt");
        Row currentRow = layPlanViewObject.getCurrentRow();

        String value = null;
        try {
            value = currentRow.getAttribute("CutNumber").toString();
            System.out.println("cutnumber 1 --------------->" + value);
        } catch (Exception e) {
            ;
        }

        System.out.println("View row count --->" + it.getRowCount());
        double total = 0.0, a = 0.0;
        while (it.hasNext()) {
            Row r = it.next();
            String value1 = null;
            try {
                value1 = r.getAttribute("CutNumber").toString();
                System.out.println("cutnumber 2 --------------->" + value1);
            } catch (Exception e) {
                ;
            }

            System.out.println("loooop------------------->" + r);
            if (r == currentRow) {
                total = total + currentVal;
                System.out.println("Current row if -------------->");
                continue;

            }

            try {
                System.out.println("Befrore A value ---------------------->");

                if (value.equalsIgnoreCase(value1))
                    a =
  Double.parseDouble(r.getAttribute("CutQty").toString());
                System.out.println("After A value ---------------------->");
            } catch (Exception e) {

                System.out.println("Exception-->" + a);
            }
            if (value.equalsIgnoreCase(value1))
                total = total + a;
        }
        System.out.println("total value --------------->" + total);
        it.closeRowSetIterator();
        return total;


    }


    public void setCutDetail(RichTable cutDetail) {
        this.cutDetail = cutDetail;
    }

    public RichTable getCutDetail() {
        return cutDetail;
    }

    public void setSelectAllTable(RichTable selectAllTable) {
        this.selectAllTable = selectAllTable;
    }

    public RichTable getSelectAllTable() {
        return selectAllTable;
    }

    public void SelectAll(ActionEvent actionEvent) {
        System.out.println("SelectAll");
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllLines");
        operationBinding.getParamsMap().put("flag", "Y");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable);
        System.out.println("selectAllTable");
    }

    public void DeSelectAll(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding = executeOperation("selectAllLines");
        operationBinding.getParamsMap().put("flag", "N");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllTable);
    }


    public void setRationNo(RichInputListOfValues rationNo) {
        this.rationNo = rationNo;

        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        String TransactionType;
        try {
            TransactionType = getRationNo().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }
        System.out.println("in hte rationo plan no set "+TransactionType);
        userSession.setAttribute("RationNo", TransactionType);
        System.out.println("in hte rationo plan no set ");
        System.out.println("ratioplanno"+TransactionType);
        

    }

    public RichInputListOfValues getRationNo() {
        
        System.out.println("in side geeting "+rationNo);
        return rationNo;
    }


    public void editPopupFetchListenerRec(PopupFetchEvent popupFetchEvent) {
        // Add event code here...setPopUpWhereClause

        OperationBinding operationBinding =
            executeOperation("setPopUpWhereClauseRec");
        operationBinding.execute();
    }


    public void editDialogListenerRec(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding =
                executeOperation("populateBundlesRec");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineTable);
        }

    }

    public void editPopupFetchListenerThirdParty(PopupFetchEvent popupFetchEvent) {
        // Add event code here...setPopUpWhereClause

        OperationBinding operationBinding =
            executeOperation("setPopUpWhereClauseThirdParty");
        operationBinding.execute();
    }


    public void editDialogListenerThirdParty(DialogEvent dialogEvent) {
        // Add event code here...
        if (dialogEvent.getOutcome().name().equals("ok")) {
            OperationBinding operationBinding =
                executeOperation("populateBundlesThirdParty");
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineTable);
        }

    }

    public void CreateRequisition(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding operationBinding =
            executeOperation("CreateRequisition");
        operationBinding.execute();

        if (!operationBinding.getErrors().isEmpty()) {
            System.out.println("if errors-->");
            // List errors = operationBinding.getErrors();
        }
        //optional
        Object methodReturnValue = operationBinding.getResult();
        String message = null;
        if (methodReturnValue != null) {
            message = methodReturnValue.toString();
        } else {
            message = "Failed! .";
        }
        FacesMessage fm = new FacesMessage(message);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);

    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String SaveAll() {

        setIssuedQuantityLineTotal(getTotalQuantityDetailTotal());
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineTable);

        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        return null;
    }

    public double getTotalQuantityDetailTotal() {

        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContext.findDataControl("AppModuleDataControl"); //
        ApplicationModule am = dc.getApplicationModule();
        ViewObject findViewObject =
            am.findViewObject("MnjMfgCutissuanceSzlineView1"); //MnjMfgCutissuanceSzlineView1

        RowSetIterator it = findViewObject.createRowSetIterator("tt");
        double val = 0.0, total = 0.0;
        while (it.hasNext()) {

            Row r = it.next();
            try {
                val =
Double.parseDouble(r.getAttribute("IssQuantity").toString());
            } catch (Exception e) {
                ;
            }

            total = total + val;
        } //end of while loop
        it.closeRowSetIterator();
        return total;
    }

    public void setIssuedQuantityLineTotal(double val) {

        oracle.adf.view.rich.component.UIXTable table = getCutDetail();
        // Get the Selected Row key set iterator
        java.util.Iterator selectionIt = table.getSelectedRowKeys().iterator();
        double ply = 0.0;
        while (selectionIt.hasNext()) {
            Object rowKey = selectionIt.next();
            table.setRowKey(rowKey);
            int index = table.getRowIndex();
            FacesCtrlHierNodeBinding row =
                (FacesCtrlHierNodeBinding)table.getRowData(index);
            Row selectedRow = row.getRow();

            selectedRow.setAttribute("IssuedQuantity", val);

        }

    }

    public void setTransactionTypeBind(RichInputComboboxListOfValues transactionTypeBind) {
        this.transactionTypeBind = transactionTypeBind;


        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);


        String TransactionType;

        try {
            TransactionType = getTransactionTypeBind().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }

        System.out.println("TransactionType   " + TransactionType);

        if (TransactionType.equals("Issued to Stich")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Stich");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
        }
        if (TransactionType.equals("Issued to Print")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Print");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
        }
        if (TransactionType.equals("Issued to Emb")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Emb");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
            System.out.println("In set attribute for TT.....!!!!!");
        }
        if (TransactionType.equals("Receive from Emb")) {
            userSession.setAttribute("TransactionType", "Receive");
            userSession.setAttribute("TransactionTypeNew", "Receive from Emb");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType Receive");
            System.out.println("in if of Emb rec.......");
        }
        if (TransactionType.equals("Receive from Print")) {
            userSession.setAttribute("TransactionType", "Receive");
            userSession.setAttribute("TransactionTypeNew",
                                     "Receive from Print");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType Receive");
        }
        if (TransactionType.equals("Issued to Third Party")) {
            userSession.setAttribute("TransactionType", "TP");
            userSession.setAttribute("TransactionTypeNew",
                                     "Issued to Third Party");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType TP");
        }
        if (TransactionType.equals("Receive from Third Party")) {
            userSession.setAttribute("TransactionType", "TP");
            userSession.setAttribute("TransactionTypeNew",
                                     "Receive from Third Party");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType TP");
        }
        if (TransactionType.equals("Null")) {
            userSession.setAttribute("TransactionType", "Null");
            userSession.setAttribute("TransactionTypeNew", "Null");
            System.out.println("---TransactionType TP");
        }


    }

    public RichInputComboboxListOfValues getTransactionTypeBind() {

        System.out.println("getter");

        return transactionTypeBind;


    }

    public void SetTransactionTypeSession() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);


        String TransactionType;

        try {
            TransactionType = getTransactionTypeBind().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }

        System.out.println("TransactionType   " + TransactionType);

        if (TransactionType.equals("Issued to Stich")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Stich");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
        }
        if (TransactionType.equals("Issued to Print")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Print");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
        }
        if (TransactionType.equals("Issued to Emb")) {
            userSession.setAttribute("TransactionType", "Issue");
            userSession.setAttribute("TransactionTypeNew", "Issued to Emb");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType Issue");
        }
        if (TransactionType.equals("Receive from Emb")) {
            userSession.setAttribute("TransactionType", "Receive");
            userSession.setAttribute("TransactionTypeNew", "Receive from Emb");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType Receive");
        }
        if (TransactionType.equals("Receive from Print")) {
            userSession.setAttribute("TransactionType", "Receive");
            userSession.setAttribute("TransactionTypeNew",
                                     "Receive from Print");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType Receive");
        }
        if (TransactionType.equals("Issued to Third Party")) {
            userSession.setAttribute("TransactionType", "TP");
            userSession.setAttribute("TransactionTypeNew",
                                     "Issued to Third Party");
            userSession.setAttribute("ReceiveDocNo", "Issue");
            System.out.println("---TransactionType TP");
        }
        if (TransactionType.equals("Receive from Third Party")) {
            userSession.setAttribute("TransactionType", "TP");
            userSession.setAttribute("TransactionTypeNew",
                                     "Receive from Third Party");
            userSession.setAttribute("ReceiveDocNo", "Receive");
            System.out.println("---TransactionType TP");
        }
        if (TransactionType.equals("Null")) {
            userSession.setAttribute("TransactionType", "Null");
            userSession.setAttribute("TransactionTypeNew", "Null");
            System.out.println("---TransactionType TP");
        }


    }

    public void TransactionTypeValueChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //
        SetTransactionTypeSession();
        AdfFacesContext.getCurrentInstance().addPartialTarget(fillBundleIssueButtonBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(fillBundleReceiveButtonBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(fillBundleThirdPartyButtonBinding);

    }

    public void setFillBundleIssueButtonBinding(RichCommandButton fillBundleIssueButtonBinding) {
        this.fillBundleIssueButtonBinding = fillBundleIssueButtonBinding;
    }

    public RichCommandButton getFillBundleIssueButtonBinding() {
        return fillBundleIssueButtonBinding;
    }

    public void setFillBundleReceiveButtonBinding(RichCommandButton fillBundleReceiveButtonBinding) {
        this.fillBundleReceiveButtonBinding = fillBundleReceiveButtonBinding;
    }

    public RichCommandButton getFillBundleReceiveButtonBinding() {
        return fillBundleReceiveButtonBinding;
    }

    public void setFillBundleThirdPartyButtonBinding(RichCommandButton fillBundleThirdPartyButtonBinding) {
        this.fillBundleThirdPartyButtonBinding =
                fillBundleThirdPartyButtonBinding;
    }

    public RichCommandButton getFillBundleThirdPartyButtonBinding() {
        return fillBundleThirdPartyButtonBinding;
    }

    public void setStyleBind(RichInputComboboxListOfValues styleBind) {
        this.styleBind = styleBind;
        System.out.println("Style Session");
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        String TransactionType;

        try {
            TransactionType = getStyleBind().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }
        userSession.setAttribute("Style", TransactionType);
    }

    public RichInputComboboxListOfValues getStyleBind() {
        return styleBind;
    }

    public void setSeason(RichInputText season) {
        this.season = season;
        System.out.println("Season Session");
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);

        String TransactionType;

        try {
            TransactionType = getSeason().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }

        userSession.setAttribute("Season", TransactionType);
    }

    public RichInputText getSeason() {
        return season;
    }

    public void setBuyerId(RichInputText buyerId) {
        this.buyerId = buyerId;
        System.out.println("Buyer Session");
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        String TransactionType;

        try {
            TransactionType = getBuyerId().getValue().toString();
        } catch (Exception e) {
            // TODO: Add catch code
            TransactionType = "Null";
        }
        userSession.setAttribute("BuyerId", TransactionType);
    }

    public RichInputText getBuyerId() {
        return buyerId;
    }

    public void SelectAllValues(ActionEvent actionEvent) {
        OperationBinding operationBinding = executeOperation("selectAllPopupLines");
        operationBinding.getParamsMap().put("flag", "Y");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllValuesTable);
        // Add event code here...
    }

    public void setSelectAllTableValues(RichPopup selectAllTableValues) {
        this.selectAllTableValues = selectAllTableValues;
    }

    public RichPopup getSelectAllTableValues() {
        return selectAllTableValues;
    }

    public void setSelectAllValuesTable(RichTable selectAllValuesTable) {
        this.selectAllValuesTable = selectAllValuesTable;
    }

    public RichTable getSelectAllValuesTable() {
        return selectAllValuesTable;
    }

    public void DeSelectAllValues(ActionEvent actionEvent) {
        OperationBinding operationBinding = executeOperation("selectAllPopupLines");
        operationBinding.getParamsMap().put("flag", "N");
        operationBinding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(selectAllValuesTable);
    }
}
