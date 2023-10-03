// Generated from C:/Users/charl/OneDrive - University of Sussex/Compilers/Coursework/coursework v0.3/123456/task1/src\Infix.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InfixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, BOOLLIT=3, SEMICOLON=4, ASSEQUAL=5, LPAREN=6, RPAREN=7, 
		COMMA=8, IF=9, THEN=10, ELSE=11, WHILE=12, DO=13, REPEAT=14, UNTIL=15, 
		PRINT=16, SPACE=17, NEWLINE=18, EXPSKIP=19, EQUAL=20, GREATER=21, LESS=22, 
		GREATEREQ=23, LESSEQ=24, PLUS=25, MINUS=26, MULTIPLY=27, DIVIDE=28, AND=29, 
		OR=30, XOR=31, INT=32, BOOL=33, UNIT=34, TRUE=35, FALSE=36, INTLIT=37, 
		IDFR=38, WS=39;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_vardec = 2, RULE_body = 3, RULE_block = 4, 
		RULE_ene = 5, RULE_type = 6, RULE_exp = 7, RULE_args = 8, RULE_binop = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "vardec", "body", "block", "ene", "type", "exp", "args", 
			"binop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", null, "';'", "':='", "'('", "')'", "','", "'if'", 
			"'then'", "'else'", "'while'", "'do'", "'repeat'", "'until'", "'print'", 
			"'space'", "'newline'", "'skip'", "'=='", "'<'", "'>'", "'<='", "'>='", 
			"'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'int'", "'bool'", "'unit'", 
			"'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "BOOLLIT", "SEMICOLON", "ASSEQUAL", "LPAREN", "RPAREN", 
			"COMMA", "IF", "THEN", "ELSE", "WHILE", "DO", "REPEAT", "UNTIL", "PRINT", 
			"SPACE", "NEWLINE", "EXPSKIP", "EQUAL", "GREATER", "LESS", "GREATEREQ", 
			"LESSEQ", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "AND", "OR", "XOR", 
			"INT", "BOOL", "UNIT", "TRUE", "FALSE", "INTLIT", "IDFR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Infix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InfixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(InfixParser.EOF, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				dec();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << UNIT))) != 0) );
			setState(25);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDFR() { return getToken(InfixParser.IDFR, 0); }
		public TerminalNode LPAREN() { return getToken(InfixParser.LPAREN, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(InfixParser.RPAREN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			type();
			setState(28);
			match(IDFR);
			setState(29);
			match(LPAREN);
			setState(30);
			vardec();
			setState(31);
			match(RPAREN);
			setState(32);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> IDFR() { return getTokens(InfixParser.IDFR); }
		public TerminalNode IDFR(int i) {
			return getToken(InfixParser.IDFR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(InfixParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(InfixParser.COMMA, i);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterVardec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitVardec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitVardec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardec);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case UNIT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(34);
				type();
				setState(35);
				match(IDFR);
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(36);
					match(COMMA);
					setState(37);
					type();
					setState(38);
					match(IDFR);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> IDFR() { return getTokens(InfixParser.IDFR); }
		public TerminalNode IDFR(int i) {
			return getToken(InfixParser.IDFR, i);
		}
		public List<TerminalNode> ASSEQUAL() { return getTokens(InfixParser.ASSEQUAL); }
		public TerminalNode ASSEQUAL(int i) {
			return getToken(InfixParser.ASSEQUAL, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InfixParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InfixParser.SEMICOLON, i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << UNIT))) != 0)) {
				{
				{
				setState(49);
				type();
				setState(50);
				match(IDFR);
				setState(51);
				match(ASSEQUAL);
				setState(52);
				exp();
				setState(53);
				match(SEMICOLON);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			ene();
			setState(61);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public EneContext ene() {
			return getRuleContext(EneContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			ene();
			setState(65);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EneContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(InfixParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(InfixParser.SEMICOLON, i);
		}
		public EneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ene; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterEne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitEne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitEne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EneContext ene() throws RecognitionException {
		EneContext _localctx = new EneContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ene);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			exp();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(68);
				match(SEMICOLON);
				setState(69);
				exp();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(InfixParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(InfixParser.BOOL, 0); }
		public TerminalNode UNIT() { return getToken(InfixParser.UNIT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << UNIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RepeatExpContext extends ExpContext {
		public TerminalNode REPEAT() { return getToken(InfixParser.REPEAT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(InfixParser.UNTIL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterRepeatExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitRepeatExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitRepeatExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpContext extends ExpContext {
		public TerminalNode IDFR() { return getToken(InfixParser.IDFR, 0); }
		public IdentifierExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterIdentifierExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitIdentifierExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitIdentifierExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExpContext extends ExpContext {
		public TerminalNode PRINT() { return getToken(InfixParser.PRINT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterPrintExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitPrintExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitPrintExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewLineExpContext extends ExpContext {
		public TerminalNode NEWLINE() { return getToken(InfixParser.NEWLINE, 0); }
		public NewLineExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterNewLineExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitNewLineExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitNewLineExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssExpContext extends ExpContext {
		public TerminalNode IDFR() { return getToken(InfixParser.IDFR, 0); }
		public TerminalNode ASSEQUAL() { return getToken(InfixParser.ASSEQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterAssExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitAssExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitAssExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenElseExpContext extends ExpContext {
		public TerminalNode IF() { return getToken(InfixParser.IF, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode THEN() { return getToken(InfixParser.THEN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(InfixParser.ELSE, 0); }
		public IfThenElseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterIfThenElseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitIfThenElseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitIfThenElseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipExpContext extends ExpContext {
		public TerminalNode EXPSKIP() { return getToken(InfixParser.EXPSKIP, 0); }
		public SkipExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSkipExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSkipExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSkipExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockExpContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBlockExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBlockExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBlockExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExpContext extends ExpContext {
		public TerminalNode IDFR() { return getToken(InfixParser.IDFR, 0); }
		public TerminalNode LPAREN() { return getToken(InfixParser.LPAREN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(InfixParser.RPAREN, 0); }
		public FuncExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterFuncExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitFuncExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitFuncExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileExpContext extends ExpContext {
		public TerminalNode WHILE() { return getToken(InfixParser.WHILE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DO() { return getToken(InfixParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterWhileExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitWhileExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitWhileExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLitExpContext extends ExpContext {
		public TerminalNode INTLIT() { return getToken(InfixParser.INTLIT, 0); }
		public IntLitExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterIntLitExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitIntLitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitIntLitExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinopExpContext extends ExpContext {
		public TerminalNode LPAREN() { return getToken(InfixParser.LPAREN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(InfixParser.RPAREN, 0); }
		public BinopExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBinopExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBinopExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBinopExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpaceExpContext extends ExpContext {
		public TerminalNode SPACE() { return getToken(InfixParser.SPACE, 0); }
		public SpaceExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterSpaceExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitSpaceExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitSpaceExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLitExpContext extends ExpContext {
		public TerminalNode BOOLLIT() { return getToken(InfixParser.BOOLLIT, 0); }
		public BoolLitExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterBoolLitExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitBoolLitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitBoolLitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(IDFR);
				setState(78);
				match(ASSEQUAL);
				setState(79);
				exp();
				}
				break;
			case 2:
				_localctx = new BinopExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(LPAREN);
				setState(81);
				exp();
				setState(82);
				binop();
				setState(83);
				exp();
				setState(84);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new FuncExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(IDFR);
				setState(87);
				match(LPAREN);
				setState(88);
				args();
				setState(89);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new BlockExpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				block();
				}
				break;
			case 5:
				_localctx = new IfThenElseExpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(IF);
				setState(93);
				exp();
				setState(94);
				match(THEN);
				setState(95);
				block();
				setState(96);
				match(ELSE);
				setState(97);
				block();
				}
				break;
			case 6:
				_localctx = new WhileExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				match(WHILE);
				setState(100);
				exp();
				setState(101);
				match(DO);
				setState(102);
				block();
				}
				break;
			case 7:
				_localctx = new RepeatExpContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				match(REPEAT);
				setState(105);
				block();
				setState(106);
				match(UNTIL);
				setState(107);
				exp();
				}
				break;
			case 8:
				_localctx = new PrintExpContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(109);
				match(PRINT);
				setState(110);
				exp();
				}
				break;
			case 9:
				_localctx = new SpaceExpContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				match(SPACE);
				}
				break;
			case 10:
				_localctx = new NewLineExpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				match(NEWLINE);
				}
				break;
			case 11:
				_localctx = new SkipExpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(113);
				match(EXPSKIP);
				}
				break;
			case 12:
				_localctx = new IdentifierExpContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(114);
				match(IDFR);
				}
				break;
			case 13:
				_localctx = new IntLitExpContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(115);
				match(INTLIT);
				}
				break;
			case 14:
				_localctx = new BoolLitExpContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(116);
				match(BOOLLIT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(InfixParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(InfixParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << BOOLLIT) | (1L << LPAREN) | (1L << IF) | (1L << WHILE) | (1L << REPEAT) | (1L << PRINT) | (1L << SPACE) | (1L << NEWLINE) | (1L << EXPSKIP) | (1L << INTLIT) | (1L << IDFR))) != 0)) {
				{
				setState(119);
				exp();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(120);
					match(COMMA);
					setState(121);
					exp();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
	 
		public BinopContext() { }
		public void copyFrom(BinopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndBinopContext extends BinopContext {
		public TerminalNode AND() { return getToken(InfixParser.AND, 0); }
		public AndBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterAndBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitAndBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitAndBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterBinopContext extends BinopContext {
		public TerminalNode GREATER() { return getToken(InfixParser.GREATER, 0); }
		public GreaterBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterGreaterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitGreaterBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitGreaterBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplyBinopContext extends BinopContext {
		public TerminalNode MULTIPLY() { return getToken(InfixParser.MULTIPLY, 0); }
		public MultiplyBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterMultiplyBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitMultiplyBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitMultiplyBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusBinopContext extends BinopContext {
		public TerminalNode PLUS() { return getToken(InfixParser.PLUS, 0); }
		public PlusBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterPlusBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitPlusBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitPlusBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqBinopContext extends BinopContext {
		public TerminalNode EQUAL() { return getToken(InfixParser.EQUAL, 0); }
		public EqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterEqBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitEqBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqBinopContext extends BinopContext {
		public TerminalNode GREATEREQ() { return getToken(InfixParser.GREATEREQ, 0); }
		public GreaterEqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterGreaterEqBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitGreaterEqBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitGreaterEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessBinopContext extends BinopContext {
		public TerminalNode LESS() { return getToken(InfixParser.LESS, 0); }
		public LessBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterLessBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitLessBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitLessBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XorBinopContext extends BinopContext {
		public TerminalNode XOR() { return getToken(InfixParser.XOR, 0); }
		public XorBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterXorBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitXorBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitXorBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessEqBinopContext extends BinopContext {
		public TerminalNode LESSEQ() { return getToken(InfixParser.LESSEQ, 0); }
		public LessEqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterLessEqBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitLessEqBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitLessEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusBinopContext extends BinopContext {
		public TerminalNode MINUS() { return getToken(InfixParser.MINUS, 0); }
		public MinusBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterMinusBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitMinusBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitMinusBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrBinopContext extends BinopContext {
		public TerminalNode OR() { return getToken(InfixParser.OR, 0); }
		public OrBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterOrBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitOrBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitOrBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideBinopContext extends BinopContext {
		public TerminalNode DIVIDE() { return getToken(InfixParser.DIVIDE, 0); }
		public DivideBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).enterDivideBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InfixListener ) ((InfixListener)listener).exitDivideBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InfixVisitor ) return ((InfixVisitor<? extends T>)visitor).visitDivideBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binop);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				_localctx = new EqBinopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(EQUAL);
				}
				break;
			case GREATER:
				_localctx = new GreaterBinopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(GREATER);
				}
				break;
			case LESS:
				_localctx = new LessBinopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(LESS);
				}
				break;
			case GREATEREQ:
				_localctx = new GreaterEqBinopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(GREATEREQ);
				}
				break;
			case LESSEQ:
				_localctx = new LessEqBinopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(LESSEQ);
				}
				break;
			case PLUS:
				_localctx = new PlusBinopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(134);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusBinopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(MINUS);
				}
				break;
			case MULTIPLY:
				_localctx = new MultiplyBinopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(136);
				match(MULTIPLY);
				}
				break;
			case DIVIDE:
				_localctx = new DivideBinopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(137);
				match(DIVIDE);
				}
				break;
			case AND:
				_localctx = new AndBinopContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(138);
				match(AND);
				}
				break;
			case OR:
				_localctx = new OrBinopContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(139);
				match(OR);
				}
				break;
			case XOR:
				_localctx = new XorBinopContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(140);
				match(XOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u0090\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0004\u0000\u0016\b\u0000\u000b"+
		"\u0000\f\u0000\u0017\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002)\b"+
		"\u0002\n\u0002\f\u0002,\t\u0002\u0001\u0002\u0003\u0002/\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u00038\b\u0003\n\u0003\f\u0003;\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005G\b\u0005\n\u0005\f\u0005J\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007v\b\u0007\u0001\b\u0001\b\u0001\b\u0005\b{\b\b\n\b\f"+
		"\b~\t\b\u0003\b\u0080\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008e\b\t\u0001"+
		"\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000"+
		"\u0001\u0001\u0000 \"\u00a4\u0000\u0015\u0001\u0000\u0000\u0000\u0002"+
		"\u001b\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00060\u0001"+
		"\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000"+
		"\fK\u0001\u0000\u0000\u0000\u000eu\u0001\u0000\u0000\u0000\u0010\u007f"+
		"\u0001\u0000\u0000\u0000\u0012\u008d\u0001\u0000\u0000\u0000\u0014\u0016"+
		"\u0003\u0002\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0003\f\u0006\u0000\u001c\u001d\u0005&\u0000\u0000\u001d\u001e\u0005"+
		"\u0006\u0000\u0000\u001e\u001f\u0003\u0004\u0002\u0000\u001f \u0005\u0007"+
		"\u0000\u0000 !\u0003\u0006\u0003\u0000!\u0003\u0001\u0000\u0000\u0000"+
		"\"#\u0003\f\u0006\u0000#*\u0005&\u0000\u0000$%\u0005\b\u0000\u0000%&\u0003"+
		"\f\u0006\u0000&\'\u0005&\u0000\u0000\')\u0001\u0000\u0000\u0000($\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+/\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000-/\u0001\u0000\u0000\u0000.\"\u0001\u0000\u0000\u0000.-\u0001\u0000"+
		"\u0000\u0000/\u0005\u0001\u0000\u0000\u000009\u0005\u0001\u0000\u0000"+
		"12\u0003\f\u0006\u000023\u0005&\u0000\u000034\u0005\u0005\u0000\u0000"+
		"45\u0003\u000e\u0007\u000056\u0005\u0004\u0000\u000068\u0001\u0000\u0000"+
		"\u000071\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000"+
		"\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<=\u0003\n\u0005\u0000=>\u0005\u0002\u0000\u0000>\u0007"+
		"\u0001\u0000\u0000\u0000?@\u0005\u0001\u0000\u0000@A\u0003\n\u0005\u0000"+
		"AB\u0005\u0002\u0000\u0000B\t\u0001\u0000\u0000\u0000CH\u0003\u000e\u0007"+
		"\u0000DE\u0005\u0004\u0000\u0000EG\u0003\u000e\u0007\u0000FD\u0001\u0000"+
		"\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001"+
		"\u0000\u0000\u0000I\u000b\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000KL\u0007\u0000\u0000\u0000L\r\u0001\u0000\u0000\u0000MN\u0005&\u0000"+
		"\u0000NO\u0005\u0005\u0000\u0000Ov\u0003\u000e\u0007\u0000PQ\u0005\u0006"+
		"\u0000\u0000QR\u0003\u000e\u0007\u0000RS\u0003\u0012\t\u0000ST\u0003\u000e"+
		"\u0007\u0000TU\u0005\u0007\u0000\u0000Uv\u0001\u0000\u0000\u0000VW\u0005"+
		"&\u0000\u0000WX\u0005\u0006\u0000\u0000XY\u0003\u0010\b\u0000YZ\u0005"+
		"\u0007\u0000\u0000Zv\u0001\u0000\u0000\u0000[v\u0003\b\u0004\u0000\\]"+
		"\u0005\t\u0000\u0000]^\u0003\u000e\u0007\u0000^_\u0005\n\u0000\u0000_"+
		"`\u0003\b\u0004\u0000`a\u0005\u000b\u0000\u0000ab\u0003\b\u0004\u0000"+
		"bv\u0001\u0000\u0000\u0000cd\u0005\f\u0000\u0000de\u0003\u000e\u0007\u0000"+
		"ef\u0005\r\u0000\u0000fg\u0003\b\u0004\u0000gv\u0001\u0000\u0000\u0000"+
		"hi\u0005\u000e\u0000\u0000ij\u0003\b\u0004\u0000jk\u0005\u000f\u0000\u0000"+
		"kl\u0003\u000e\u0007\u0000lv\u0001\u0000\u0000\u0000mn\u0005\u0010\u0000"+
		"\u0000nv\u0003\u000e\u0007\u0000ov\u0005\u0011\u0000\u0000pv\u0005\u0012"+
		"\u0000\u0000qv\u0005\u0013\u0000\u0000rv\u0005&\u0000\u0000sv\u0005%\u0000"+
		"\u0000tv\u0005\u0003\u0000\u0000uM\u0001\u0000\u0000\u0000uP\u0001\u0000"+
		"\u0000\u0000uV\u0001\u0000\u0000\u0000u[\u0001\u0000\u0000\u0000u\\\u0001"+
		"\u0000\u0000\u0000uc\u0001\u0000\u0000\u0000uh\u0001\u0000\u0000\u0000"+
		"um\u0001\u0000\u0000\u0000uo\u0001\u0000\u0000\u0000up\u0001\u0000\u0000"+
		"\u0000uq\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000ut\u0001\u0000\u0000\u0000v\u000f\u0001\u0000\u0000\u0000"+
		"w|\u0003\u000e\u0007\u0000xy\u0005\b\u0000\u0000y{\u0003\u000e\u0007\u0000"+
		"zx\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000\u007fw\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0011\u0001\u0000\u0000\u0000\u0081\u008e\u0005\u0014"+
		"\u0000\u0000\u0082\u008e\u0005\u0015\u0000\u0000\u0083\u008e\u0005\u0016"+
		"\u0000\u0000\u0084\u008e\u0005\u0017\u0000\u0000\u0085\u008e\u0005\u0018"+
		"\u0000\u0000\u0086\u008e\u0005\u0019\u0000\u0000\u0087\u008e\u0005\u001a"+
		"\u0000\u0000\u0088\u008e\u0005\u001b\u0000\u0000\u0089\u008e\u0005\u001c"+
		"\u0000\u0000\u008a\u008e\u0005\u001d\u0000\u0000\u008b\u008e\u0005\u001e"+
		"\u0000\u0000\u008c\u008e\u0005\u001f\u0000\u0000\u008d\u0081\u0001\u0000"+
		"\u0000\u0000\u008d\u0082\u0001\u0000\u0000\u0000\u008d\u0083\u0001\u0000"+
		"\u0000\u0000\u008d\u0084\u0001\u0000\u0000\u0000\u008d\u0085\u0001\u0000"+
		"\u0000\u0000\u008d\u0086\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000"+
		"\u0000\u0000\u008d\u0088\u0001\u0000\u0000\u0000\u008d\u0089\u0001\u0000"+
		"\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0013\u0001\u0000"+
		"\u0000\u0000\t\u0017*.9Hu|\u007f\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}