package ex.java7.resources_3;

import ex.java7.AutoCloseableFactory;
import ex.java7.TryBody;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 04.09.13
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class ThreeImpl implements Three {
    @Override
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable {
        AutoCloseable f1 = factoryA.create();
        AutoCloseable f2 ;
        try {
            f2 = factoryB.create();
        }
        catch (Throwable exCrF2)
        {
            try {
                f1.close();
            }
            catch (Throwable exClF1){
                exCrF2.addSuppressed(exClF1);
            }
            throw exCrF2;
        }
        AutoCloseable f3;
        try {
            f3 = factoryC.create();
        }
        catch (Throwable exCrF3){
            try {
                f2.close();
            }
            catch (Throwable exClF2){
                exCrF3.addSuppressed(exClF2);
            }
            try {
                f1.close();
            }
            catch (Throwable exClF1){
                exCrF3.addSuppressed(exClF1);
            }
            throw exCrF3;
        }
        try {
            body.runBody();
        }
        catch (Throwable bodyEx){
            try {
                f3.close();
            }
            catch (Throwable exClF3){
                bodyEx.addSuppressed(exClF3);
            }
            try{
                f2.close();
            }
            catch (Throwable exClF2){
                bodyEx.addSuppressed(exClF2);
            }
            try {
                f1.close();
            }
            catch (Throwable exClF1){
                bodyEx.addSuppressed(exClF1);
            }
            throw bodyEx;
        }
        try{
            f3.close();
        }
        catch (Throwable exClF3){
            try{
                f2.close();
            }
            catch (Throwable exClF2){
                exClF3.addSuppressed(exClF2);
            }
            try {
                f1.close();
            }
            catch (Throwable exClF1){
                exClF3.addSuppressed(exClF1);
            }
            throw exClF3;
        }
        try{
            f2.close();
        }
        catch (Throwable exClF2){
            try {
                f1.close();
            }
            catch (Throwable exClF1){
                exClF2.addSuppressed(exClF1);
            }
            throw exClF2;
        }
        f1.close();
    }
}
