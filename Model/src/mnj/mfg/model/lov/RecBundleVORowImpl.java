package mnj.mfg.model.lov;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 06 15:33:41 BDT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecBundleVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        DetailId {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getDetailId();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setDetailId((Number)value);
            }
        }
        ,
        BundleNo {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getBundleNo();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setBundleNo((String)value);
            }
        }
        ,
        SizeValue {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getSizeValue();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setSizeValue((String)value);
            }
        }
        ,
        FromPieceNo {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getFromPieceNo();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setFromPieceNo((Number)value);
            }
        }
        ,
        ToPieceNo {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getToPieceNo();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setToPieceNo((Number)value);
            }
        }
        ,
        Shade {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getShade();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setShade((String)value);
            }
        }
        ,
        TotalQty {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getTotalQty();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setTotalQty((Number)value);
            }
        }
        ,
        CutNo {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getCutNo();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setCutNo((String)value);
            }
        }
        ,
        IssueDoc {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getIssueDoc();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setIssueDoc((String)value);
            }
        }
        ,
        Flag {
            public Object get(RecBundleVORowImpl obj) {
                return obj.getFlag();
            }

            public void put(RecBundleVORowImpl obj, Object value) {
                obj.setFlag((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(RecBundleVORowImpl object);

        public abstract void put(RecBundleVORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int DETAILID = AttributesEnum.DetailId.index();
    public static final int BUNDLENO = AttributesEnum.BundleNo.index();
    public static final int SIZEVALUE = AttributesEnum.SizeValue.index();
    public static final int FROMPIECENO = AttributesEnum.FromPieceNo.index();
    public static final int TOPIECENO = AttributesEnum.ToPieceNo.index();
    public static final int SHADE = AttributesEnum.Shade.index();
    public static final int TOTALQTY = AttributesEnum.TotalQty.index();
    public static final int CUTNO = AttributesEnum.CutNo.index();
    public static final int ISSUEDOC = AttributesEnum.IssueDoc.index();
    public static final int FLAG = AttributesEnum.Flag.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RecBundleVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute DetailId.
     * @return the DetailId
     */
    public Number getDetailId() {
        return (Number) getAttributeInternal(DETAILID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DetailId.
     * @param value value to set the  DetailId
     */
    public void setDetailId(Number value) {
        setAttributeInternal(DETAILID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BundleNo.
     * @return the BundleNo
     */
    public String getBundleNo() {
        return (String) getAttributeInternal(BUNDLENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BundleNo.
     * @param value value to set the  BundleNo
     */
    public void setBundleNo(String value) {
        setAttributeInternal(BUNDLENO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SizeValue.
     * @return the SizeValue
     */
    public String getSizeValue() {
        return (String) getAttributeInternal(SIZEVALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SizeValue.
     * @param value value to set the  SizeValue
     */
    public void setSizeValue(String value) {
        setAttributeInternal(SIZEVALUE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute FromPieceNo.
     * @return the FromPieceNo
     */
    public Number getFromPieceNo() {
        return (Number) getAttributeInternal(FROMPIECENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute FromPieceNo.
     * @param value value to set the  FromPieceNo
     */
    public void setFromPieceNo(Number value) {
        setAttributeInternal(FROMPIECENO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ToPieceNo.
     * @return the ToPieceNo
     */
    public Number getToPieceNo() {
        return (Number) getAttributeInternal(TOPIECENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ToPieceNo.
     * @param value value to set the  ToPieceNo
     */
    public void setToPieceNo(Number value) {
        setAttributeInternal(TOPIECENO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Shade.
     * @return the Shade
     */
    public String getShade() {
        return (String) getAttributeInternal(SHADE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Shade.
     * @param value value to set the  Shade
     */
    public void setShade(String value) {
        setAttributeInternal(SHADE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TotalQty.
     * @return the TotalQty
     */
    public Number getTotalQty() {
        return (Number) getAttributeInternal(TOTALQTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TotalQty.
     * @param value value to set the  TotalQty
     */
    public void setTotalQty(Number value) {
        setAttributeInternal(TOTALQTY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CutNo.
     * @return the CutNo
     */
    public String getCutNo() {
        return (String) getAttributeInternal(CUTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CutNo.
     * @param value value to set the  CutNo
     */
    public void setCutNo(String value) {
        setAttributeInternal(CUTNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute IssueDoc.
     * @return the IssueDoc
     */
    public String getIssueDoc() {
        return (String) getAttributeInternal(ISSUEDOC);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute IssueDoc.
     * @param value value to set the  IssueDoc
     */
    public void setIssueDoc(String value) {
        setAttributeInternal(ISSUEDOC, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Flag.
     * @return the Flag
     */
    public String getFlag() {
        return (String) getAttributeInternal(FLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Flag.
     * @param value value to set the  Flag
     */
    public void setFlag(String value) {
        setAttributeInternal(FLAG, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
