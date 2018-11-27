/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Henry
 * @version $Id: GxyDO.java, v 0.1 2018-07-29 下午11:13 Henry Exp $$
 */
public class GxyDO implements Serializable {
    private static final long serialVersionUID = 73359776089917726L;

    private String id;

    private String yjzx;

    private String name;
    /**
     * 0-male
     * 1-female
     */
    private int gender;


    private Date birthday;


    private Date ckdDate;

    private int gxy;

    private int tnb;

    private int gxg;

    private String sbp1;

    private String dbp1;

    private String sbp2;

    private String dbp2;

    private String sbp3;

    private String dbp3;

    private int dtxy;

    private double avgSsy;

    private double avgSzy;

    private double avgSsyDay;

    private double avgSzyDay;

    private double avgSsyNight;

    private double avgSzyNight;

    private double stdSsy;

    private double stdSzy;

    private int ndb;

    private double ndb24h;

    private int hasBloodN;

    private int nczRed;

    private double xhs;

    private int whiteCellCount;

    private int midCellCount;

    private int xxbCount;

    private int xj;

    private int xhdb;

    private int ipth;

    private int bloodG;

    private int bloodL;

    private int ctgs;

    private String xzcc;

    private String ivsFjg;

    private String zfdx;

    private String zsdx;

    private String sjghd;

    private String zshbhd;


    private String sxfs;

    private int bmhs;

    /**
     * Getter method for property <tt>yjzx</tt>.
     *
     * @return property value of yjzx
     */
    public String getYjzx() {
        return yjzx;
    }

    /**
     * Setter method for property <tt>yjzx</tt>.
     *
     * @param yjzx value to be assigned to property yjzx
     */
    public void setYjzx(String yjzx) {
        this.yjzx = yjzx;
    }

    /**
     * Getter method for property <tt>zfdx</tt>.
     *
     * @return property value of zfdx
     */
    public String getZfdx() {
        return zfdx;
    }

    /**
     * Setter method for property <tt>zfdx</tt>.
     *
     * @param zfdx value to be assigned to property zfdx
     */
    public void setZfdx(String zfdx) {
        this.zfdx = zfdx;
    }

    /**
     * Getter method for property <tt>zsdx</tt>.
     *
     * @return property value of zsdx
     */
    public String getZsdx() {
        return zsdx;
    }

    /**
     * Setter method for property <tt>zsdx</tt>.
     *
     * @param zsdx value to be assigned to property zsdx
     */
    public void setZsdx(String zsdx) {
        this.zsdx = zsdx;
    }

    /**
     * Getter method for property <tt>sjghd</tt>.
     *
     * @return property value of sjghd
     */
    public String getSjghd() {
        return sjghd;
    }

    /**
     * Setter method for property <tt>sjghd</tt>.
     *
     * @param sjghd value to be assigned to property sjghd
     */
    public void setSjghd(String sjghd) {
        this.sjghd = sjghd;
    }

    /**
     * Getter method for property <tt>zshbhd</tt>.
     *
     * @return property value of zshbhd
     */
    public String getZshbhd() {
        return zshbhd;
    }

    /**
     * Setter method for property <tt>zshbhd</tt>.
     *
     * @param zshbhd value to be assigned to property zshbhd
     */
    public void setZshbhd(String zshbhd) {
        this.zshbhd = zshbhd;
    }

    /**
     * Getter method for property <tt>sxfs</tt>.
     *
     * @return property value of sxfs
     */
    public String getSxfs() {
        return sxfs;
    }

    /**
     * Setter method for property <tt>sxfs</tt>.
     *
     * @param sxfs value to be assigned to property sxfs
     */
    public void setSxfs(String sxfs) {
        this.sxfs = sxfs;
    }

    /**
     * Getter method for property <tt>bmhs</tt>.
     *
     * @return property value of bmhs
     */
    public int getBmhs() {
        return bmhs;
    }

    /**
     * Setter method for property <tt>bmhs</tt>.
     *
     * @param bmhs value to be assigned to property bmhs
     */
    public void setBmhs(int bmhs) {
        this.bmhs = bmhs;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>gender</tt>.
     *
     * @return property value of gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * Setter method for property <tt>gender</tt>.
     *
     * @param gender value to be assigned to property gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Getter method for property <tt>birthday</tt>.
     *
     * @return property value of birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Setter method for property <tt>birthday</tt>.
     *
     * @param birthday value to be assigned to property birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Getter method for property <tt>ckdDate</tt>.
     *
     * @return property value of ckdDate
     */
    public Date getCkdDate() {
        return ckdDate;
    }

    /**
     * Setter method for property <tt>ckdDate</tt>.
     *
     * @param ckdDate value to be assigned to property ckdDate
     */
    public void setCkdDate(Date ckdDate) {
        this.ckdDate = ckdDate;
    }

    /**
     * Getter method for property <tt>gxy</tt>.
     *
     * @return property value of gxy
     */
    public int getGxy() {
        return gxy;
    }

    /**
     * Setter method for property <tt>gxy</tt>.
     *
     * @param gxy value to be assigned to property gxy
     */
    public void setGxy(int gxy) {
        this.gxy = gxy;
    }

    /**
     * Getter method for property <tt>tnb</tt>.
     *
     * @return property value of tnb
     */
    public int getTnb() {
        return tnb;
    }

    /**
     * Setter method for property <tt>tnb</tt>.
     *
     * @param tnb value to be assigned to property tnb
     */
    public void setTnb(int tnb) {
        this.tnb = tnb;
    }

    /**
     * Getter method for property <tt>gxg</tt>.
     *
     * @return property value of gxg
     */
    public int getGxg() {
        return gxg;
    }

    /**
     * Setter method for property <tt>gxg</tt>.
     *
     * @param gxg value to be assigned to property gxg
     */
    public void setGxg(int gxg) {
        this.gxg = gxg;
    }

    /**
     * Getter method for property <tt>sbp1</tt>.
     *
     * @return property value of sbp1
     */
    public String getSbp1() {
        return sbp1;
    }

    /**
     * Setter method for property <tt>sbp1</tt>.
     *
     * @param sbp1 value to be assigned to property sbp1
     */
    public void setSbp1(String sbp1) {
        this.sbp1 = sbp1;
    }

    /**
     * Getter method for property <tt>dbp1</tt>.
     *
     * @return property value of dbp1
     */
    public String getDbp1() {
        return dbp1;
    }

    /**
     * Setter method for property <tt>dbp1</tt>.
     *
     * @param dbp1 value to be assigned to property dbp1
     */
    public void setDbp1(String dbp1) {
        this.dbp1 = dbp1;
    }

    /**
     * Getter method for property <tt>sbp2</tt>.
     *
     * @return property value of sbp2
     */
    public String getSbp2() {
        return sbp2;
    }

    /**
     * Setter method for property <tt>sbp2</tt>.
     *
     * @param sbp2 value to be assigned to property sbp2
     */
    public void setSbp2(String sbp2) {
        this.sbp2 = sbp2;
    }

    /**
     * Getter method for property <tt>dbp2</tt>.
     *
     * @return property value of dbp2
     */
    public String getDbp2() {
        return dbp2;
    }

    /**
     * Setter method for property <tt>dbp2</tt>.
     *
     * @param dbp2 value to be assigned to property dbp2
     */
    public void setDbp2(String dbp2) {
        this.dbp2 = dbp2;
    }

    /**
     * Getter method for property <tt>sbp3</tt>.
     *
     * @return property value of sbp3
     */
    public String getSbp3() {
        return sbp3;
    }

    /**
     * Setter method for property <tt>sbp3</tt>.
     *
     * @param sbp3 value to be assigned to property sbp3
     */
    public void setSbp3(String sbp3) {
        this.sbp3 = sbp3;
    }

    /**
     * Getter method for property <tt>dbp3</tt>.
     *
     * @return property value of dbp3
     */
    public String getDbp3() {
        return dbp3;
    }

    /**
     * Setter method for property <tt>dbp3</tt>.
     *
     * @param dbp3 value to be assigned to property dbp3
     */
    public void setDbp3(String dbp3) {
        this.dbp3 = dbp3;
    }

    /**
     * Getter method for property <tt>dtxy</tt>.
     *
     * @return property value of dtxy
     */
    public int getDtxy() {
        return dtxy;
    }

    /**
     * Setter method for property <tt>dtxy</tt>.
     *
     * @param dtxy value to be assigned to property dtxy
     */
    public void setDtxy(int dtxy) {
        this.dtxy = dtxy;
    }

    /**
     * Getter method for property <tt>avgSsy</tt>.
     *
     * @return property value of avgSsy
     */
    public double getAvgSsy() {
        return avgSsy;
    }

    /**
     * Setter method for property <tt>avgSsy</tt>.
     *
     * @param avgSsy value to be assigned to property avgSsy
     */
    public void setAvgSsy(double avgSsy) {
        this.avgSsy = avgSsy;
    }

    /**
     * Getter method for property <tt>avgSzy</tt>.
     *
     * @return property value of avgSzy
     */
    public double getAvgSzy() {
        return avgSzy;
    }

    /**
     * Setter method for property <tt>avgSzy</tt>.
     *
     * @param avgSzy value to be assigned to property avgSzy
     */
    public void setAvgSzy(double avgSzy) {
        this.avgSzy = avgSzy;
    }

    /**
     * Getter method for property <tt>avgSsyDay</tt>.
     *
     * @return property value of avgSsyDay
     */
    public double getAvgSsyDay() {
        return avgSsyDay;
    }

    /**
     * Setter method for property <tt>avgSsyDay</tt>.
     *
     * @param avgSsyDay value to be assigned to property avgSsyDay
     */
    public void setAvgSsyDay(double avgSsyDay) {
        this.avgSsyDay = avgSsyDay;
    }

    /**
     * Getter method for property <tt>avgSzyDay</tt>.
     *
     * @return property value of avgSzyDay
     */
    public double getAvgSzyDay() {
        return avgSzyDay;
    }

    /**
     * Setter method for property <tt>avgSzyDay</tt>.
     *
     * @param avgSzyDay value to be assigned to property avgSzyDay
     */
    public void setAvgSzyDay(double avgSzyDay) {
        this.avgSzyDay = avgSzyDay;
    }

    /**
     * Getter method for property <tt>avgSsyNight</tt>.
     *
     * @return property value of avgSsyNight
     */
    public double getAvgSsyNight() {
        return avgSsyNight;
    }

    /**
     * Setter method for property <tt>avgSsyNight</tt>.
     *
     * @param avgSsyNight value to be assigned to property avgSsyNight
     */
    public void setAvgSsyNight(double avgSsyNight) {
        this.avgSsyNight = avgSsyNight;
    }

    /**
     * Getter method for property <tt>avgSzyNight</tt>.
     *
     * @return property value of avgSzyNight
     */
    public double getAvgSzyNight() {
        return avgSzyNight;
    }

    /**
     * Setter method for property <tt>avgSzyNight</tt>.
     *
     * @param avgSzyNight value to be assigned to property avgSzyNight
     */
    public void setAvgSzyNight(double avgSzyNight) {
        this.avgSzyNight = avgSzyNight;
    }

    /**
     * Getter method for property <tt>stdSsy</tt>.
     *
     * @return property value of stdSsy
     */
    public double getStdSsy() {
        return stdSsy;
    }

    /**
     * Setter method for property <tt>stdSsy</tt>.
     *
     * @param stdSsy value to be assigned to property stdSsy
     */
    public void setStdSsy(double stdSsy) {
        this.stdSsy = stdSsy;
    }

    /**
     * Getter method for property <tt>stdSzy</tt>.
     *
     * @return property value of stdSzy
     */
    public double getStdSzy() {
        return stdSzy;
    }

    /**
     * Setter method for property <tt>stdSzy</tt>.
     *
     * @param stdSzy value to be assigned to property stdSzy
     */
    public void setStdSzy(double stdSzy) {
        this.stdSzy = stdSzy;
    }

    /**
     * Getter method for property <tt>ndb</tt>.
     *
     * @return property value of ndb
     */
    public int getNdb() {
        return ndb;
    }

    /**
     * Setter method for property <tt>ndb</tt>.
     *
     * @param ndb value to be assigned to property ndb
     */
    public void setNdb(int ndb) {
        this.ndb = ndb;
    }

    /**
     * Getter method for property <tt>ndb24h</tt>.
     *
     * @return property value of ndb24h
     */
    public double getNdb24h() {
        return ndb24h;
    }

    /**
     * Setter method for property <tt>ndb24h</tt>.
     *
     * @param ndb24h value to be assigned to property ndb24h
     */
    public void setNdb24h(double ndb24h) {
        this.ndb24h = ndb24h;
    }

    /**
     * Getter method for property <tt>hasBloodN</tt>.
     *
     * @return property value of hasBloodN
     */
    public int getHasBloodN() {
        return hasBloodN;
    }

    /**
     * Setter method for property <tt>hasBloodN</tt>.
     *
     * @param hasBloodN value to be assigned to property hasBloodN
     */
    public void setHasBloodN(int hasBloodN) {
        this.hasBloodN = hasBloodN;
    }

    /**
     * Getter method for property <tt>nczRed</tt>.
     *
     * @return property value of nczRed
     */
    public int getNczRed() {
        return nczRed;
    }

    /**
     * Setter method for property <tt>nczRed</tt>.
     *
     * @param nczRed value to be assigned to property nczRed
     */
    public void setNczRed(int nczRed) {
        this.nczRed = nczRed;
    }

    /**
     * Getter method for property <tt>xhs</tt>.
     *
     * @return property value of xhs
     */
    public double getXhs() {
        return xhs;
    }

    /**
     * Setter method for property <tt>xhs</tt>.
     *
     * @param xhs value to be assigned to property xhs
     */
    public void setXhs(double xhs) {
        this.xhs = xhs;
    }

    /**
     * Getter method for property <tt>whiteCellCount</tt>.
     *
     * @return property value of whiteCellCount
     */
    public int getWhiteCellCount() {
        return whiteCellCount;
    }

    /**
     * Setter method for property <tt>whiteCellCount</tt>.
     *
     * @param whiteCellCount value to be assigned to property whiteCellCount
     */
    public void setWhiteCellCount(int whiteCellCount) {
        this.whiteCellCount = whiteCellCount;
    }

    /**
     * Getter method for property <tt>midCellCount</tt>.
     *
     * @return property value of midCellCount
     */
    public int getMidCellCount() {
        return midCellCount;
    }

    /**
     * Setter method for property <tt>midCellCount</tt>.
     *
     * @param midCellCount value to be assigned to property midCellCount
     */
    public void setMidCellCount(int midCellCount) {
        this.midCellCount = midCellCount;
    }

    /**
     * Getter method for property <tt>xxbCount</tt>.
     *
     * @return property value of xxbCount
     */
    public int getXxbCount() {
        return xxbCount;
    }

    /**
     * Setter method for property <tt>xxbCount</tt>.
     *
     * @param xxbCount value to be assigned to property xxbCount
     */
    public void setXxbCount(int xxbCount) {
        this.xxbCount = xxbCount;
    }

    /**
     * Getter method for property <tt>xj</tt>.
     *
     * @return property value of xj
     */
    public int getXj() {
        return xj;
    }

    /**
     * Setter method for property <tt>xj</tt>.
     *
     * @param xj value to be assigned to property xj
     */
    public void setXj(int xj) {
        this.xj = xj;
    }

    /**
     * Getter method for property <tt>xhdb</tt>.
     *
     * @return property value of xhdb
     */
    public int getXhdb() {
        return xhdb;
    }

    /**
     * Setter method for property <tt>xhdb</tt>.
     *
     * @param xhdb value to be assigned to property xhdb
     */
    public void setXhdb(int xhdb) {
        this.xhdb = xhdb;
    }

    /**
     * Getter method for property <tt>ipth</tt>.
     *
     * @return property value of ipth
     */
    public int getIpth() {
        return ipth;
    }

    /**
     * Setter method for property <tt>ipth</tt>.
     *
     * @param ipth value to be assigned to property ipth
     */
    public void setIpth(int ipth) {
        this.ipth = ipth;
    }

    /**
     * Getter method for property <tt>bloodG</tt>.
     *
     * @return property value of bloodG
     */
    public int getBloodG() {
        return bloodG;
    }

    /**
     * Setter method for property <tt>bloodG</tt>.
     *
     * @param bloodG value to be assigned to property bloodG
     */
    public void setBloodG(int bloodG) {
        this.bloodG = bloodG;
    }

    /**
     * Getter method for property <tt>bloodL</tt>.
     *
     * @return property value of bloodL
     */
    public int getBloodL() {
        return bloodL;
    }

    /**
     * Setter method for property <tt>bloodL</tt>.
     *
     * @param bloodL value to be assigned to property bloodL
     */
    public void setBloodL(int bloodL) {
        this.bloodL = bloodL;
    }

    /**
     * Getter method for property <tt>ctgs</tt>.
     *
     * @return property value of ctgs
     */
    public int getCtgs() {
        return ctgs;
    }

    /**
     * Setter method for property <tt>ctgs</tt>.
     *
     * @param ctgs value to be assigned to property ctgs
     */
    public void setCtgs(int ctgs) {
        this.ctgs = ctgs;
    }

    /**
     * Getter method for property <tt>xzcc</tt>.
     *
     * @return property value of xzcc
     */
    public String getXzcc() {
        return xzcc;
    }

    /**
     * Setter method for property <tt>xzcc</tt>.
     *
     * @param xzcc value to be assigned to property xzcc
     */
    public void setXzcc(String xzcc) {
        this.xzcc = xzcc;
    }

    /**
     * Getter method for property <tt>ivsFjg</tt>.
     *
     * @return property value of ivsFjg
     */
    public String getIvsFjg() {
        return ivsFjg;
    }

    /**
     * Setter method for property <tt>ivsFjg</tt>.
     *
     * @param ivsFjg value to be assigned to property ivsFjg
     */
    public void setIvsFjg(String ivsFjg) {
        this.ivsFjg = ivsFjg;
    }
}