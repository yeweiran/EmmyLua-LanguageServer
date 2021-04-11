package com.tang.vscode.formatter

enum class FormattingType {
    General,
    Comment,
    Function,
    LocalFunction,

    FunctionBody,
    Block,
    DoBlock,

    Statement,
    IfStatement,
    ForAStatement,
    ForBStatement,
    WhileStatement,
    RepeatStatement,
    AssignStatement,
    LocalStatement,
    ExprStatement,
    BreakStatement,
    EmptyStatement,
    ReturnStatement,
    GotoStatement,
    LabelStatement,

    CallExpr,
    IndexExpr,
    LiteralExpr,
    BinaryExpr,
    UnaryExpr,
    NamedExpr,
    TableExpr,
    TableField,
    TableFieldSep,

    Closure,
    ParentExpr,
    Expr,
    ExprList,

    Arg,
    CallArgs,
    SingleArg,
    KeyWorld,
    BinaryOperator,
    UnaryOperator,
    Operator,
    NameDef,
    NameDefList,
    Id,
    Error
}