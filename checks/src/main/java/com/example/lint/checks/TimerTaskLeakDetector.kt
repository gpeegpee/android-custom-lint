package com.example.lint.checks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Category.Companion.PERFORMANCE
import org.jetbrains.uast.UElement
import java.util.*

class TimerTaskLeakDetector : Detector(), Detector.UastScanner {
    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return super.createUastHandler(context)
    }

    override fun getApplicableUastTypes(): List<Class<out UElement?>>? {
        return super.getApplicableUastTypes()
    }

    companion object {
        private const val ID = "TimerTaskLeak"
        private const val DESCRIPTION = "TimerTask should be canceled"
        private const val EXPLANATION = "We should cancel TimerTask when activity is destroyed"
        private val CATEGORY: Category = PERFORMANCE
        private const val PRIORITY = 4
        private val SEVERITY = Severity.WARNING

        @JvmField
        val ISSUE = Issue.create(
            ID,
            DESCRIPTION,
            EXPLANATION,
            CATEGORY,
            PRIORITY,
            SEVERITY,
            Implementation(TimerTaskLeakDetector::class.java, EnumSet.of(Scope.JAVA_FILE))
        )
    }
}