package com.github.lzenczuk.aws.lambda.annotation.processor;

import com.github.lzenczuk.aws.lambda.annotation.Lambda;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by lzenczuk on 28/03/17.
 */
@SupportedAnnotationTypes("com.github.lzenczuk.aws.lambda.annotation.Lambda")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AwsAnnotationProcessor extends AbstractProcessor{

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        Set<? extends Element> lambdaElements = roundEnv.getElementsAnnotatedWith(Lambda.class);

        lambdaElements.stream().forEach(element -> {
            if(element.getKind() == ElementKind.METHOD){
                String methodName = element.getSimpleName().toString();
                String handlerClassName = element.getEnclosingElement().toString();
                System.out.println("Handler: "+handlerClassName+"::"+methodName);
            }else{
                System.out.println("Unexpected element kind: "+element.getKind());
            }
        });

        return false;
    }
}
