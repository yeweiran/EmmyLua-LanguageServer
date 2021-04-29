package com.tang.vscode.formatter

import java.lang.StringBuilder

class FormattingContext {
    // 输出所用的
    public val sb = StringBuilder()
    public var currentLineWidth = 0

    private val blockEnvQueue: MutableList<FormattingBlockEnv> = mutableListOf()
    private var firstEnv = true


    public fun enterBlockEnv(indent: Int = -1, firstLineIndent: Boolean = true) {
        if (firstEnv) {
            firstEnv = false
            blockEnvQueue.add(FormattingBlockEnv(this, 0))
            return
        }

        val lastEnv = blockEnvQueue.last()
        val newEnv = FormattingBlockEnv(this,
                if (indent == -1) lastEnv.indent + FormattingOptions.indent else indent)
        blockEnvQueue.add(newEnv)
    }

    public fun exitBlockEnv() {
        blockEnvQueue.removeAt(blockEnvQueue.lastIndex);
    }

    public fun print(text: String, autoAlignment: Boolean = true): FormattingContext {
        blockEnvQueue.last().print(text, autoAlignment)
        return this
    }

    public fun getFormattingResult(): String {
        return sb.toString()
    }

    public fun getCurrentCharacter(): Int {
        val indent = blockEnvQueue.last().indent
        return if (currentLineWidth <= indent) 0 else currentLineWidth - indent
    }

}