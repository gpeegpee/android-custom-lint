package com.example.lint.checks;

import com.android.tools.lint.client.api.UElementHandler;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UElement;

import java.util.EnumSet;
import java.util.List;


public class TimerTaskLeakDetector extends Detector implements Detector.UastScanner {

    private static final String ID = "TimerTaskLeak";
    private static final String DESCRIPTION = "TimerTask should be canceled";
    private static final String EXPLANATION = "We should cancel TimerTask when activity is destroyed";
    private static final Category CATEGORY = Category.PERFORMANCE;
    private static final int PRIORITY = 4;
    private static final Severity SEVERITY = Severity.WARNING;

    public static final Issue ISSUE = Issue.create(
            ID,
            DESCRIPTION,
            EXPLANATION,
            CATEGORY,
            PRIORITY,
            SEVERITY,
            new Implementation(TimerTaskLeakDetector.class, EnumSet.of(Scope.JAVA_FILE))
    );

    @Nullable
    @Override
    public UElementHandler createUastHandler(@NotNull JavaContext context) {
        return super.createUastHandler(context);
    }

    @Nullable
    @Override
    public List<Class<? extends UElement>> getApplicableUastTypes() {
        return super.getApplicableUastTypes();
    }
}
