package com.zhangpeilin.concurrent.chapter10;

/**
 * @author 张沛霖
 * @date 2020/12/17
 */
public class BreakDelegateClassLoader extends ClassLoader {

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //1
        synchronized (getClassLoadingLock(name)){
            //2
            Class<?> klass = findLoadedClass(name);
            //3
            if (klass == null){
                //4
                if (name.startsWith("java.") || name.startsWith("javax")){
                    try{
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e){

                    }
                } else {
                    //5
                    try {
                        klass = this.findClass(name);
                    } catch (ClassNotFoundException e){

                    }
                    //6
                    if (klass == null){
                        if (getParent() != null){
                            klass = getParent().loadClass(name);
                        } else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }
            //7
            if (null == klass){
                throw new ClassNotFoundException("The class " + name + "not found.");
            }
            if (resolve){
                resolveClass(klass);
            }
            return klass;
        }
    }
}
